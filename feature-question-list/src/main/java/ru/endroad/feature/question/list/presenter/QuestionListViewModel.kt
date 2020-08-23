package ru.endroad.feature.question.list.presenter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.endroad.feature.question.list.di.QuestionListRouter
import ru.endroad.shared.voting.QuestionsDataSource
import ru.endroad.shared.voting.model.QuestionList

class QuestionListViewModel(
	private val questionsDataSource: QuestionsDataSource,
	private val questionListRouter: QuestionListRouter
) : ViewModel() {

	val questionList = MutableLiveData<QuestionList>()

	init {
		viewModelScope.launch {
			questionList.value = questionsDataSource.get()
		}
	}

	fun onCLickSoonQuestion(questionId: Long) {
		questionListRouter.openQuestion(questionId)
	}

	fun onCLickOpenQuestion(questionId: Long) {
		questionListRouter.openQuestion(questionId)
	}

	fun onCLickCompletedQuestion(questionId: Long) {
		questionListRouter.openCompletedQuestion(questionId)
	}
}