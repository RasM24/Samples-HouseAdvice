package ru.endroad.houseadvice.navigation.di

import org.koin.core.qualifier.named
import org.koin.dsl.module
import ru.endroad.feature.navigation.HubNavigationRouter
import ru.endroad.feature.onboard.di.OnBoardRouting
import ru.endroad.feature.question.list.di.QuestionListRouter
import ru.endroad.houseadvice.R
import ru.endroad.houseadvice.feature.push.PushRouting
import ru.endroad.houseadvice.navigation.navigator.ContentNavigator
import ru.endroad.houseadvice.navigation.navigator.NavigatorHolder
import ru.endroad.houseadvice.navigation.navigator.RootNavigator
import ru.endroad.houseadvice.navigation.routers.HubNavigationRouterImpl
import ru.endroad.houseadvice.navigation.routers.MainNavigation
import ru.endroad.houseadvice.navigation.routers.OnBoardRoutingImpl
import ru.endroad.houseadvice.navigation.routers.PushRoutingImpl
import ru.endroad.houseadvice.navigation.routers.QuestionListRouterImpl

val rootNavigatorQualifier = named("rootNavigatorQualifier")
val contentNavigatorQualifier = named("contentNavigatorQualifier")

val moduleNavigation = module {
	single<NavigatorHolder>(contentNavigatorQualifier) { ContentNavigator(R.id.content) }
	single<NavigatorHolder>(rootNavigatorQualifier) { RootNavigator(R.id.root) }

	single { MainNavigation(get(rootNavigatorQualifier), get(contentNavigatorQualifier), get()) }
	single<PushRouting> { PushRoutingImpl(get(contentNavigatorQualifier)) }
	single<OnBoardRouting> { OnBoardRoutingImpl(get(rootNavigatorQualifier), get(contentNavigatorQualifier)) }
	single<HubNavigationRouter> { HubNavigationRouterImpl(get(contentNavigatorQualifier)) }
	single<QuestionListRouter> { QuestionListRouterImpl(get(contentNavigatorQualifier)) }
}