package ru.endroad.houseadvice.navigation.routers

import ru.endroad.feature.question.list.di.QuestionListRouter
import ru.endroad.feature.report.QuestionReportFragment
import ru.endroad.feature.report.QuestionReportFragment.Companion.setArgument
import ru.endroad.feature.voting.view.VotingFragment
import ru.endroad.feature.voting.view.VotingFragment.Companion.setArgument
import ru.endroad.houseadvice.navigation.navigator.NavigatorHolder

class QuestionListRouterImpl(private val navigationHolder: NavigatorHolder) : QuestionListRouter {

	override fun openQuestion(questionId: Long) {
		navigationHolder.open(VotingFragment().apply { setArgument(questionId) })
	}

	override fun openCompletedQuestion(questionId: Long) {
		navigationHolder.open(QuestionReportFragment().apply { setArgument(questionId) })
	}
}