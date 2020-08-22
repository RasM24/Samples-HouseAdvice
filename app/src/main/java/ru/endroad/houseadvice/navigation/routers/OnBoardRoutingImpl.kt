package ru.endroad.houseadvice.navigation.routers

import ru.endroad.feature.navigation.HubFragment
import ru.endroad.feature.onboard.di.OnBoardRouting
import ru.endroad.feature.question.list.view.QuestionListFragment
import ru.endroad.houseadvice.navigation.navigator.NavigatorHolder

class OnBoardRoutingImpl(
	private val rootNavigatorHolder: NavigatorHolder,
	private val contentNavigatorHolder: NavigatorHolder
) : OnBoardRouting {

	override fun openStartScreen() {
		rootNavigatorHolder.changeRoot(HubFragment())
		contentNavigatorHolder.changeRoot(QuestionListFragment())
	}
}