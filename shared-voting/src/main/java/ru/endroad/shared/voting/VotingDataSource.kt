package ru.endroad.shared.voting

import ru.endroad.shared.voting.model.Vote

class VotingDataSource {

	private val hardcodeData = mutableMapOf<Long, Vote>()

	suspend fun get(questionId: Long): Vote {
		return hardcodeData[questionId] ?: Vote.NO_VOTE
	}

	suspend fun vote(questionId: Long, vote: Vote) {
		hardcodeData[questionId] = vote
	}
}