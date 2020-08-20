package ru.endroad.feature.voting.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.endroad.feature.voting.model.VotingDataSource

class VotingPresenter(private val votingDataSource: VotingDataSource) : ViewModel() {

	val screenState = MutableLiveData<VotingScreenState>()

	init {
		viewModelScope.launch {
			val data = votingDataSource.get()
			screenState.value = VotingScreenState.Data(data.title, data.information, data.vote)
		}
	}

	fun onYesClick() = vote(VOTE.YES)
	fun onNoClick() = vote(VOTE.NO)
	fun onAbstainedClick() = vote(VOTE.ABSTAINED)

	private fun vote(vote: VOTE) {
		viewModelScope.launch {
			votingDataSource.vote(vote)

			val data = votingDataSource.get()
			screenState.value = VotingScreenState.Data(data.title, data.information, data.vote)
		}
	}
}