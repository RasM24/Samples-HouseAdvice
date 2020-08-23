package ru.endroad.houseadvice.navigation.navigator

import ru.endroad.feature.onboard.data.OnBoardingAvailableDataSource
import ru.endroad.feature.onboard.view.OnBoardingFragment
import ru.endroad.feature.question.list.view.QuestionListFragment
import ru.endroad.feature.voting.view.VotingFragment
import ru.endroad.houseadvice.navigation.navigator.NavigatorHolder

class MainNavigation(
	private val navigatorHolder: NavigatorHolder,
	private val onBoardingAvailableDataSource: OnBoardingAvailableDataSource
) {

	fun openInitialScreen() {
		if (onBoardingAvailableDataSource.isOnBoardAvailable()) {
			navigatorHolder.changeRoot(OnBoardingFragment())
		} else {
			navigatorHolder.changeRoot(QuestionListFragment())
		}
	}
}