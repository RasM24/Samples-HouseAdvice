package ru.endroad.shared.voting.model

typealias QuestionList = List<Question>

data class Question(
	val id: Long,
	val title: String,
	val information: String,
	val status: QuestionStatus,
	val startData: Long,
	val endData: Long
)