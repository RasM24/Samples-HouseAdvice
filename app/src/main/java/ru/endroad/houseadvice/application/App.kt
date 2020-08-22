package ru.endroad.houseadvice.application

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.endroad.feature.authentication.di.moduleAuthentication
import ru.endroad.feature.onboard.di.moduleOnBoarding
import ru.endroad.feature.profile.moduleProfile
import ru.endroad.feature.question.list.di.moduleQuestionList
import ru.endroad.feature.voting.di.moduleVoting
import ru.endroad.houseadvice.deeplink.moduleDeeplink
import ru.endroad.houseadvice.navigation.di.moduleNavigation
import ru.endroad.shared.profile.moduleProfileData
import ru.endroad.shared.voting.di.moduleQuestionData

class App : Application() {

	private val navigationsModule = arrayOf(
		moduleNavigation
	)

	private val featuresModule = arrayOf(
		moduleAuthentication,
		moduleVoting,
		moduleOnBoarding,
		moduleQuestionList,
		moduleProfile
	)

	private val sharedsModule = arrayOf(
		moduleQuestionData,
		moduleProfileData
	)

	override fun onCreate() {
		super.onCreate()

		startKoin {
			androidContext(this@App)
			modules(
				moduleDeeplink,
				*navigationsModule,
				*featuresModule,
				*sharedsModule
			)
		}
	}
}