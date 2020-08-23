package ru.endroad.feature.voting.model

import ru.endroad.feature.voting.view.VOTE

class VotingDataSource {

	private var hardcore = VotingRoom(
		title = "Голосуем за снос соседнего здания",
		information = "Жители соседних домов осаждают нашу крепость, милорд!",
		vote = VOTE.NO_VOTE
	)

	suspend fun get(): VotingRoom =
		hardcore

	suspend fun vote(vote: VOTE) {
		hardcore = hardcore.copy(vote = vote)
	}
}