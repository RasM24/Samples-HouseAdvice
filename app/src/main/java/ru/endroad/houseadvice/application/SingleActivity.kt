package ru.endroad.houseadvice.application

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_single.toolbar
import org.koin.android.ext.android.inject
import ru.endroad.feature.navigation.HubFragment
import ru.endroad.houseadvice.R
import ru.endroad.houseadvice.deeplink.DeeplinkHandler
import ru.endroad.houseadvice.navigation.navigator.MainNavigation
import ru.endroad.houseadvice.navigation.navigator.NavigatorHolder
import ru.endroad.houseadvice.navigation.utils.changeRoot

class SingleActivity : AppCompatActivity() {

	private val navigatorHolder by inject<NavigatorHolder>()
	private val deeplinkHandler by inject<DeeplinkHandler>()

	private val mainNavigation by inject<MainNavigation>()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		navigatorHolder.fragmentManager = supportFragmentManager
		setContentView(R.layout.activity_single)
		setSupportActionBar(toolbar)

		savedInstanceState ?: openHomeScreen()
		intent.let(::processIntent)
	}

	private fun openHomeScreen() {
		supportFragmentManager.changeRoot(HubFragment(), R.id.root)
		mainNavigation.openInitialScreen()
	}

	private fun processIntent(intent: Intent) {
		if (intent.action == Intent.ACTION_VIEW) {
			intent.data?.let(deeplinkHandler::handle)
		}
	}

	override fun onDestroy() {
		navigatorHolder.fragmentManager = null
		super.onDestroy()
	}
}