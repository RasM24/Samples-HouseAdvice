package ru.endroad.houseadvice.deeplink

import org.koin.dsl.module
import org.koin.experimental.builder.single

val moduleDeeplink = module {
	single<DeeplinkHandler>()
}