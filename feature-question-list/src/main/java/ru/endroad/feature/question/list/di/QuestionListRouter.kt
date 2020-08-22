package ru.endroad.feature.question.list.di

interface QuestionListRouter {
	fun openQuestion(questionId: Long)
	fun openCompletedQuestion(questionId: Long)
}