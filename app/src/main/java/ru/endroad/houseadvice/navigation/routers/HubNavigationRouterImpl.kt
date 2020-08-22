package ru.endroad.houseadvice.navigation.routers

import ru.endroad.feature.navigation.HubNavigationRouter
import ru.endroad.houseadvice.navigation.navigator.NavigatorHolder

class HubNavigationRouterImpl(private val navigatorHolder: NavigatorHolder) : HubNavigationRouter {

	override fun openProfile() = Unit

	override fun openVotes() = Unit

	override fun openForum() = Unit

	override fun openInformation() = Unit

	override fun openSupport() = Unit
}