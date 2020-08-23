package ru.endroad.shared.voting.di

import org.koin.dsl.module
import ru.endroad.shared.voting.QuestionsDataSource

val moduleQuestionData = module {
	single { QuestionsDataSource() }
}