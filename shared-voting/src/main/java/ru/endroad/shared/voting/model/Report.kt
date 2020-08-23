package ru.endroad.shared.voting.model

data class Report(
	val questionId: Long,
	val answer: Vote,
	val turnoutPercentage: Float,
	val checkSum: String
)