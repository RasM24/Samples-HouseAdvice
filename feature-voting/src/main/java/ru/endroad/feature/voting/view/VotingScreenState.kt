package ru.endroad.feature.voting.view

sealed class VotingScreenState {
	class Data(val title: String, val information: String, val vote: VOTE) : VotingScreenState()
}

//TODO плохое наименование
enum class VOTE {
	YES,
	NO,
	ABSTAINED,
	NO_VOTE
}