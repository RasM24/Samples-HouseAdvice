package ru.endroad.houseadvice.navigation

import org.koin.dsl.module
import ru.endroad.houseadvice.R

val moduleNavigation = module {
	single { NavigatorHolder(R.id.content) }
}