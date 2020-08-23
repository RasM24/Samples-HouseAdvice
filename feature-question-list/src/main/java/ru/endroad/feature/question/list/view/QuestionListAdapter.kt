package ru.endroad.feature.question.list.view

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.endroad.shared.voting.model.Question
import ru.endroad.shared.voting.model.QuestionList
import ru.endroad.shared.voting.model.QuestionStatus

class QuestionListAdapter(
	private val onCLickSoonQuestionListener: (Long) -> Unit,
	private val onCLickOpenQuestionListener: (Long) -> Unit,
	private val onCLickCompletedQuestionListener: (Long) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

	private var items: MutableList<Question> = mutableListOf()

	fun setList(items: QuestionList) {
		this.items.clear()
		this.items.addAll(items)
		notifyDataSetChanged()
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
		when (viewType) {
			SoonQuestionViewHolder.type      -> SoonQuestionViewHolder(onCLickSoonQuestionListener, parent)
			OpenQuestionViewHolder.type      -> OpenQuestionViewHolder(onCLickOpenQuestionListener, parent)
			CompletedQuestionViewHolder.type -> CompletedQuestionViewHolder(onCLickCompletedQuestionListener, parent)
			else                             -> throw IllegalStateException("нет такого viewHolder")
		}

	override fun getItemCount() = items.size

	override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
		when (holder) {
			is SoonQuestionViewHolder      -> holder.bind(items[position])
			is OpenQuestionViewHolder      -> holder.bind(items[position])
			is CompletedQuestionViewHolder -> holder.bind(items[position])
		}
	}

	override fun getItemViewType(position: Int): Int =
		when (items[position].status) {
			QuestionStatus.SOON      -> SoonQuestionViewHolder.type
			QuestionStatus.OPEN      -> OpenQuestionViewHolder.type
			QuestionStatus.COMPLETED -> CompletedQuestionViewHolder.type
		}
}