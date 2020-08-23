package ru.endroad.feature.onboard.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.koin.experimental.builder.single
import ru.endroad.feature.onboard.data.OnBoardingAvailableDataSource
import ru.endroad.feature.onboard.view.OnBoardPresenter

val moduleOnBoarding = module {
	single<OnBoardingAvailableDataSource>()

	viewModel { OnBoardPresenter(get(), get()) }
}