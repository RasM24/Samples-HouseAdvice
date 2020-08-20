package ru.endroad.feature.voting.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.koin.experimental.builder.single
import ru.endroad.feature.voting.model.VotingDataSource
import ru.endroad.feature.voting.view.VotingPresenter

val moduleVoting = module {

	single<VotingDataSource>()

	viewModel { VotingPresenter(get()) }
}