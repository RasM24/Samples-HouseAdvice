package ru.endroad.houseadvice.navigation.navigator

import ru.endroad.feature.onboard.data.OnBoardingAvailableDataSource
import ru.endroad.feature.onboard.view.OnBoardingFragment
import ru.endroad.feature.voting.view.VotingFragment
import ru.endroad.houseadvice.navigation.navigator.NavigatorHolder

class MainNavigation(
	private val navigatorHolder: NavigatorHolder,
	private val onBoardingAvailableDataSource: OnBoardingAvailableDataSource
) {

	fun openInitialScreen() {
		if (onBoardingAvailableDataSource.isOnBoardAvailable()) {
			navigatorHolder.open(OnBoardingFragment())
		} else {
			navigatorHolder.open(VotingFragment())
		}
	}
}