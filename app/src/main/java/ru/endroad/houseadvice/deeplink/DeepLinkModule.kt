package ru.endroad.houseadvice.deeplink

import org.koin.dsl.module
import ru.endroad.houseadvice.navigation.di.contentNavigatorQualifier
import ru.endroad.houseadvice.navigation.di.rootNavigatorQualifier

val moduleDeeplink = module {
	single { DeeplinkHandler(get(rootNavigatorQualifier), get(contentNavigatorQualifier)) }
}