package ru.endroad.feature.report

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.endroad.shared.voting.QuestionReportsDataSource
import ru.endroad.shared.voting.QuestionsDataSource
import ru.endroad.shared.voting.VotingDataSource

class QuestionReportPresenter(
	private val votingDataSource: VotingDataSource,
	private val questionsDataSource: QuestionsDataSource,
	private val questionReportsDataSource: QuestionReportsDataSource,
	private val questionId: Long
) : ViewModel() {

	val screenState = MutableLiveData<ReportScreenState>()

	init {
		viewModelScope.launch {
			val data = questionsDataSource.get(questionId)
			val report = questionReportsDataSource.get(questionId)
			val vote = votingDataSource.get(questionId)

			screenState.value = ReportScreenState.Data(data, report, vote)
		}
	}
}