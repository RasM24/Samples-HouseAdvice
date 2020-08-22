package ru.endroad.shared.voting.di

import org.koin.dsl.module
import ru.endroad.shared.voting.QuestionsDataSource
import ru.endroad.shared.voting.VotingDataSource

val moduleQuestionData = module {

	single { VotingDataSource() }
	single { QuestionsDataSource() }
}