package ru.endroad.houseadvice.navigation.routers

import ru.endroad.feature.onboard.di.OnBoardRouting
import ru.endroad.houseadvice.navigation.navigator.NavigatorHolder

class OnBoardRoutingImpl(private val navigationHolder: NavigatorHolder) : OnBoardRouting {

	override fun openStartScreen() {
		navigationHolder.back()
	}
}