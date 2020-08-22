package ru.endroad.feature.question.list.view

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.open_question_item.view.question_days_to_close
import kotlinx.android.synthetic.main.open_question_item.view.question_information
import kotlinx.android.synthetic.main.open_question_item.view.question_title
import ru.endroad.feature.question.list.R
import ru.endroad.feature.question.list.utils.getLeftCountDaysTo
import ru.endroad.feature.question.list.utils.inflate
import ru.endroad.shared.voting.model.Question

class OpenQuestionViewHolder(
	private val onCLickOpenQuestionListener: (Long) -> Unit,
	parent: ViewGroup
) : RecyclerView.ViewHolder(parent.inflate(R.layout.open_question_item)) {

	companion object {
		val type = R.id.open_question
	}

	fun bind(question: Question) {
		itemView.setOnClickListener { onCLickOpenQuestionListener(question.id) }

		itemView.question_title.text = question.title
		itemView.question_information.text = question.information
		itemView.question_days_to_close.text = "Осталось дней: ${getLeftCountDaysTo(question.endData)}"
	}
}