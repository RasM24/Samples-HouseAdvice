package ru.endroad.feature.authentication.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.koin.experimental.builder.single
import ru.endroad.feature.authentication.data.OtpDataSource
import ru.endroad.feature.authentication.view.AuthPresenter

val moduleAuthentication = module {

	single<OtpDataSource>()

	viewModel { AuthPresenter(get()) }
}