package ru.endroad.houseadvice.navigation

import org.koin.dsl.module
import org.koin.experimental.builder.single
import ru.endroad.feature.onboard.di.OnBoardRouting
import ru.endroad.houseadvice.R
import ru.endroad.houseadvice.feature.push.PushRouting

val moduleNavigation = module {
	single<NavigatorHolder> { ContentNavigator(R.id.content) }

	single<MainNavigation>()
	single<PushRouting> { PushRoutingImpl(get()) }
	single<OnBoardRouting> { OnBoardRoutingImpl(get()) }
}