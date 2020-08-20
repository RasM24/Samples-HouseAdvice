package ru.endroad.houseadvice.navigation

import org.koin.dsl.module
import ru.endroad.houseadvice.R
import ru.endroad.houseadvice.feature.push.PushRouting

val moduleNavigation = module {
	single<NavigatorHolder> { ContentNavigator(R.id.content) }

	single<PushRouting> { PushRoutingImpl(get()) }
}