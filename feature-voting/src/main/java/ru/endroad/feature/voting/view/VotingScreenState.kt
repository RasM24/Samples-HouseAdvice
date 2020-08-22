package ru.endroad.feature.voting.view

import ru.endroad.shared.voting.model.Question
import ru.endroad.shared.voting.model.Vote

sealed class VotingScreenState {
	class Data(val data: Question, val vote: Vote) : VotingScreenState()
}