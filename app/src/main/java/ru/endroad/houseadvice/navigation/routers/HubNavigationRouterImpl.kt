package ru.endroad.houseadvice.navigation.routers

import ru.endroad.feature.forum.view.ForumFragment
import ru.endroad.feature.navigation.HubNavigationRouter
import ru.endroad.feature.support.SupportFragment
import ru.endroad.feature_information.BulletinBoardFragment
import ru.endroad.houseadvice.navigation.navigator.NavigatorHolder

class HubNavigationRouterImpl(private val navigatorHolder: NavigatorHolder) : HubNavigationRouter {

	override fun openProfile() = Unit

	override fun openVotes() = Unit

	override fun openForum() {
		navigatorHolder.open(ForumFragment())
	}

	override fun openInformation() {
		navigatorHolder.open(BulletinBoardFragment())
	}

	override fun openSupport() {
		navigatorHolder.open(SupportFragment())
	}
}