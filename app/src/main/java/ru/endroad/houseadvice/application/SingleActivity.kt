package ru.endroad.houseadvice.application

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_single.toolbar
import org.koin.android.ext.android.inject
import ru.endroad.houseadvice.R
import ru.endroad.houseadvice.navigation.NavigatorHolder

class SingleActivity : AppCompatActivity() {

	private val navigatorHolder by inject<NavigatorHolder>()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		navigatorHolder.fragmentManager = supportFragmentManager
		setContentView(R.layout.activity_single)
		setSupportActionBar(toolbar)
	}

	override fun onDestroy() {
		navigatorHolder.fragmentManager = null
		super.onDestroy()
	}
}