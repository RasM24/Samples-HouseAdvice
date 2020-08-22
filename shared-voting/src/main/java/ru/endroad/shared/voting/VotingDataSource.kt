package ru.endroad.shared.voting

import ru.endroad.shared.voting.model.Vote

class VotingDataSource {

	private val hardcodeData = mutableMapOf<Long, Vote>(
		2L to Vote.NO,
		5L to Vote.NO,
		8L to Vote.ABSTAINED,
		11L to Vote.YES
	)

	suspend fun get(questionId: Long): Vote {
		return hardcodeData[questionId] ?: Vote.NO_VOTE
	}

	suspend fun vote(questionId: Long, vote: Vote) {
		hardcodeData[questionId] = vote
	}
}