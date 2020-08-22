package ru.endroad.houseadvice.application

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_single.toolbar
import org.koin.android.ext.android.inject
import ru.endroad.houseadvice.R
import ru.endroad.houseadvice.deeplink.DeeplinkHandler
import ru.endroad.houseadvice.navigation.di.contentNavigatorQualifier
import ru.endroad.houseadvice.navigation.di.rootNavigatorQualifier
import ru.endroad.houseadvice.navigation.navigator.NavigatorHolder
import ru.endroad.houseadvice.navigation.routers.MainNavigation

class SingleActivity : AppCompatActivity() {

	//TODO для более правильной реалазации необходимо разделить NavigatorHolder(отвечает только за хранение fragmentManager)
	// и RootNavigator/ContentNavigator(осуществляет переход экранов на заданном уровне навигации. Принимает в конструкторе NavigatorHolder
	private val rootNavigatorHolder by inject<NavigatorHolder>(rootNavigatorQualifier)
	private val contentNavigatorHolder by inject<NavigatorHolder>(contentNavigatorQualifier)

	private val deeplinkHandler by inject<DeeplinkHandler>()

	private val mainNavigation by inject<MainNavigation>()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_single)
		setupToolbar()

		rootNavigatorHolder.fragmentManager = supportFragmentManager
		contentNavigatorHolder.fragmentManager = supportFragmentManager

		savedInstanceState ?: openHomeScreen()
		intent.let(::processIntent)
	}

	private fun setupToolbar() {
		setSupportActionBar(toolbar)
		toolbar.setNavigationOnClickListener { onBackPressed() }
		supportFragmentManager.addOnBackStackChangedListener {
			supportActionBar?.setHomeEnabled()
		}
		supportActionBar?.setHomeEnabled()
	}

	private fun ActionBar.setHomeEnabled() {
		this.setDisplayHomeAsUpEnabled(supportFragmentManager.backStackEntryCount != 0)
	}

	private fun openHomeScreen() {
		mainNavigation.openInitialScreen()
	}

	private fun processIntent(intent: Intent) {
		if (intent.action == Intent.ACTION_VIEW) {
			intent.data?.let(deeplinkHandler::handle)
		}
	}

	override fun onDestroy() {
		rootNavigatorHolder.fragmentManager = null
		contentNavigatorHolder.fragmentManager = null
		super.onDestroy()
	}
}