package ru.endroad.feature.question.list.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.endroad.feature.question.list.presenter.QuestionListViewModel

val moduleQuestionList = module {
	viewModel { QuestionListViewModel(get(), get()) }
}