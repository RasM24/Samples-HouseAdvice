package ru.endroad.feature.forum.view

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.endroad.feature.forum.data.ForumItem

class ForumListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

	private var items: MutableList<ForumItem> = mutableListOf()

	fun setList(items: List<ForumItem>) {
		this.items.clear()
		this.items.addAll(items)
		notifyDataSetChanged()
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
		when (viewType) {
			CategoryViewHolder.type -> CategoryViewHolder(parent)
			TopicViewHolder.type    -> TopicViewHolder(parent)
			else                    -> throw IllegalStateException("нет такого viewHolder")
		}

	override fun getItemCount() = items.size

	override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
		when (holder) {
			is CategoryViewHolder -> holder.bind(items[position] as ForumItem.Category)
			is TopicViewHolder    -> holder.bind(items[position] as ForumItem.Topic)
		}
	}

	override fun getItemViewType(position: Int): Int =
		when (items[position]) {
			is ForumItem.Category -> CategoryViewHolder.type
			is ForumItem.Topic    -> TopicViewHolder.type
		}
}