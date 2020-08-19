package ru.endroad.houseadvice.application

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.endroad.houseadvice.deeplink.moduleDeeplink
import ru.endroad.houseadvice.navigation.moduleNavigation

class App : Application() {

	private val navigationModules = arrayOf(
		moduleNavigation
	)

	override fun onCreate() {
		super.onCreate()

		startKoin {
			androidContext(this@App)
			modules(
				moduleDeeplink,
				*navigationModules
			)
		}
	}
}