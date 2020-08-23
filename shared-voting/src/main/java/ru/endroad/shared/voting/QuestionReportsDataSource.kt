package ru.endroad.shared.voting

import ru.endroad.shared.voting.model.Report
import ru.endroad.shared.voting.model.Vote

//TODO идеальным и единственным правильным решением было бы использовать interface, но мне лень тратить сейчас на это время =)
class QuestionReportsDataSource {

	private val hardcodeData = listOf(
		Report(
			2,
			Vote.NO,
			92.1f,
			"sUDHLu8DkbR2nLFR"
		),
		Report(
			5,
			Vote.YES,
			76.6f,
			"T6pBd4YFEWGgdr2W"
		),
		Report(
			8,
			Vote.YES,
			88.4f,
			"6U4Z58NcfSK4ZTEw"
		)
	)

	suspend fun get(id: Long): Report {
		val question = hardcodeData.find { it.questionId == id }
		return checkNotNull(question)
	}
}