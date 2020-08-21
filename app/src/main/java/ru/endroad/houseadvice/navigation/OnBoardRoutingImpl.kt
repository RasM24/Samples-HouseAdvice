package ru.endroad.houseadvice.navigation

import ru.endroad.feature.onboard.di.OnBoardRouting

class OnBoardRoutingImpl(private val navigationHolder: NavigatorHolder) : OnBoardRouting {

	override fun openStartScreen() {
		navigationHolder.back()
	}
}