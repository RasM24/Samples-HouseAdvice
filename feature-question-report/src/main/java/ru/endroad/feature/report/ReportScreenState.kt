package ru.endroad.feature.report

import ru.endroad.shared.voting.model.Question
import ru.endroad.shared.voting.model.Report
import ru.endroad.shared.voting.model.Vote

sealed class ReportScreenState {
	class Data(val data: Question, val report: Report, val vote: Vote) : ReportScreenState()
}