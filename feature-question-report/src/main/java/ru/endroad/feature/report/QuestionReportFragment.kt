package ru.endroad.feature.report

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.question_report_layout.answer
import kotlinx.android.synthetic.main.question_report_layout.check_sum_data
import kotlinx.android.synthetic.main.question_report_layout.date
import kotlinx.android.synthetic.main.question_report_layout.turnout_percentage
import kotlinx.android.synthetic.main.question_report_layout.voting_information
import kotlinx.android.synthetic.main.question_report_layout.voting_title
import kotlinx.android.synthetic.main.question_report_layout.you_vote
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import ru.endroad.shared.voting.model.Vote
import java.text.SimpleDateFormat
import java.util.Date

class QuestionReportFragment : Fragment() {

	companion object {
		private const val QUESTION_ID = "QUESTION_ID"

		fun QuestionReportFragment.setArgument(questionId: Long) {
			arguments = bundleOf(QUESTION_ID to questionId)
		}
	}

	private val questionId: Long by lazy { checkNotNull(arguments?.getLong(QUESTION_ID)) }

	private val presenter: QuestionReportPresenter by viewModel { parametersOf(questionId) }

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
		inflater.inflate(R.layout.question_report_layout, container, false)

	override fun onActivityCreated(savedInstanceState: Bundle?) {
		super.onActivityCreated(savedInstanceState)

		presenter.screenState.observe(viewLifecycleOwner, Observer { render(it) })
	}

	private fun render(screenState: ReportScreenState) {
		when (screenState) {
			is ReportScreenState.Data -> renderData(screenState)
		}
	}

	private fun renderData(state: ReportScreenState.Data) {
		voting_title.text = state.data.title
		voting_information.text = state.data.information
		date.text = "Собрание проходило с ${formatDate(state.data.startData)} по ${formatDate(state.data.endData)}"
		you_vote.text = "Ваш голос ${state.vote.toRussian()}"
		answer.text = "Общее решение: ${state.report.answer.toRussian()}"
		turnout_percentage.text = "Явка составила: ${state.report.turnoutPercentage}%"
		check_sum_data.text = state.report.checkSum
	}

	private fun Vote.toRussian(): String = when (this) {
		Vote.YES       -> "ДА"
		Vote.NO        -> "НЕТ"
		Vote.ABSTAINED -> "ВОЗДЕРЖАЛСЯ"
		Vote.NO_VOTE   -> "НЕТ ГОЛОСА"
	}

	private fun formatDate(unix: Long): String {
		val format = SimpleDateFormat("dd MMM")

		val date = Date(unix * 1000)
		return format.format(date)
	}
}