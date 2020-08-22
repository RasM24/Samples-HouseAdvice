package ru.endroad.feature.forum.view

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.forum_category_item.view.name
import ru.endroad.feature.forum.data.ForumItem
import ru.endroad.feature.forum.utils.inflate
import ru.endroad.houseadvice.feature.forum.R

class CategoryViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(parent.inflate(R.layout.forum_category_item)) {

	companion object {
		val type = R.id.forum_category_item
	}

	fun bind(category: ForumItem.Category) {
		itemView.name.text = category.name
	}
}