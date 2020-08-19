package ru.endroad.houseadvice.application

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.endroad.houseadvice.navigation.moduleNavigation

class App : Application() {

	private val navigationModules = listOf(
		moduleNavigation
	)

	override fun onCreate() {
		super.onCreate()

		startKoin {
			androidContext(this@App)
			modules(navigationModules)
		}
	}
}