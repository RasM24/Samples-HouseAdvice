package ru.endroad.houseadvice.application

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.endroad.feature.onboard.di.moduleOnBoarding
import ru.endroad.feature.voting.di.moduleVoting
import ru.endroad.houseadvice.deeplink.moduleDeeplink
import ru.endroad.houseadvice.navigation.moduleNavigation

class App : Application() {

	private val navigationsModule = arrayOf(
		moduleNavigation
	)

	private val featuresModule = arrayOf(
		moduleVoting,
		moduleOnBoarding
	)

	override fun onCreate() {
		super.onCreate()

		startKoin {
			androidContext(this@App)
			modules(
				moduleDeeplink,
				*navigationsModule,
				*featuresModule
			)
		}
	}
}