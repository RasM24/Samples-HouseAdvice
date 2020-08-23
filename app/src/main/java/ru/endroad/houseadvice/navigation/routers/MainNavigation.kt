package ru.endroad.houseadvice.navigation.routers

import ru.endroad.feature.navigation.HubFragment
import ru.endroad.feature.onboard.data.OnBoardingAvailableDataSource
import ru.endroad.feature.onboard.view.OnBoardingFragment
import ru.endroad.feature.question.list.view.QuestionListFragment
import ru.endroad.houseadvice.navigation.navigator.NavigatorHolder

class MainNavigation(
	private val rootNavigatorHolder: NavigatorHolder,
	private val contentNavigatorHolder: NavigatorHolder,
	private val onBoardingAvailableDataSource: OnBoardingAvailableDataSource
) {

	fun openInitialScreen() {
		if (onBoardingAvailableDataSource.isOnBoardAvailable()) {
			rootNavigatorHolder.changeRoot(OnBoardingFragment())
		} else {
			rootNavigatorHolder.changeRoot(HubFragment())
			contentNavigatorHolder.changeRoot(QuestionListFragment())
		}
	}
}