package ru.endroad.feature.voting.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.endroad.shared.voting.QuestionsDataSource
import ru.endroad.shared.voting.VotingDataSource
import ru.endroad.shared.voting.model.Vote

class VotingPresenter(
	private val votingDataSource: VotingDataSource,
	private val questionsDataSource: QuestionsDataSource,
	private val questionId: Long
) : ViewModel() {

	val screenState = MutableLiveData<VotingScreenState>()

	init {
		viewModelScope.launch {
			val data = questionsDataSource.get(questionId)
			val vote = votingDataSource.get(questionId)

			screenState.value = VotingScreenState.Data(data, vote)
		}
	}

	fun onYesClick() = vote(Vote.YES)
	fun onNoClick() = vote(Vote.NO)
	fun onAbstainedClick() = vote(Vote.ABSTAINED)

	//TODO придумать как вернуть голос
	private fun vote(vote: Vote) {
		viewModelScope.launch {
			votingDataSource.vote(questionId, vote)

			val data = questionsDataSource.get(questionId)
			val acceptedVote = votingDataSource.get(questionId)

			screenState.value = VotingScreenState.Data(data, acceptedVote)
		}
	}
}