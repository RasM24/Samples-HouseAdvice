package ru.endroad.houseadvice.navigation.di

import org.koin.dsl.module
import org.koin.experimental.builder.single
import ru.endroad.feature.navigation.HubNavigationRouter
import ru.endroad.feature.onboard.di.OnBoardRouting
import ru.endroad.houseadvice.R
import ru.endroad.houseadvice.feature.push.PushRouting
import ru.endroad.houseadvice.navigation.navigator.ContentNavigator
import ru.endroad.houseadvice.navigation.routers.HubNavigationRouterImpl
import ru.endroad.houseadvice.navigation.navigator.MainNavigation
import ru.endroad.houseadvice.navigation.navigator.NavigatorHolder
import ru.endroad.houseadvice.navigation.routers.OnBoardRoutingImpl
import ru.endroad.houseadvice.navigation.routers.PushRoutingImpl

val moduleNavigation = module {
	single<NavigatorHolder> { ContentNavigator(R.id.content) }

	single<MainNavigation>()
	single<PushRouting> { PushRoutingImpl(get()) }
	single<OnBoardRouting> { OnBoardRoutingImpl(get()) }
	single<HubNavigationRouter> { HubNavigationRouterImpl(get()) }
}