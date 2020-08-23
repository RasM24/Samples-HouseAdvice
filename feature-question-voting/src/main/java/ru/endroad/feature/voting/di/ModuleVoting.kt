package ru.endroad.feature.voting.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.endroad.feature.voting.view.VotingPresenter

val moduleVoting = module {

	viewModel { (questionId: Long) -> VotingPresenter(get(), get(), questionId) }
}