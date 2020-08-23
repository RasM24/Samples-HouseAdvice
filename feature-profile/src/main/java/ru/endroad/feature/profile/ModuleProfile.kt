package ru.endroad.feature.profile

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val moduleProfile = module {
	viewModel { ProfilePresenter(get()) }
}