package ru.endroad.feature.report.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.endroad.feature.report.QuestionReportPresenter

val moduleReport = module {

	viewModel { (questionId: Long) -> QuestionReportPresenter(get(), get(), get(), questionId) }
}