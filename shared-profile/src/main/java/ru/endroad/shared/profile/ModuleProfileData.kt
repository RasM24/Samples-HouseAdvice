package ru.endroad.shared.profile

import org.koin.dsl.module

val moduleProfileData = module {
	single { ProfileDataSource() }
}