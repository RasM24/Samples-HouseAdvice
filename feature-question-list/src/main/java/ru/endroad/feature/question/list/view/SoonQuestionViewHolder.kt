package ru.endroad.feature.question.list.view

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.soon_question_item.view.question_start_date
import kotlinx.android.synthetic.main.soon_question_item.view.question_title
import ru.endroad.feature.question.list.utils.formatDate
import ru.endroad.feature.question.list.utils.inflate
import ru.endroad.houseadvice.feature.question.list.R
import ru.endroad.shared.voting.model.Question

class SoonQuestionViewHolder(
	private val onCLickSoonQuestionListener: (Long) -> Unit,
	parent: ViewGroup
) : RecyclerView.ViewHolder(parent.inflate(R.layout.soon_question_item)) {

	companion object {
		val type = R.id.soon_question
	}

	fun bind(question: Question) {
		itemView.setOnClickListener { onCLickSoonQuestionListener(question.id) }

		val startDateFormatted = formatDate(question.startData)

		itemView.question_title.text = question.title
		itemView.question_start_date.text = "Начало голосования: $startDateFormatted"
	}
}