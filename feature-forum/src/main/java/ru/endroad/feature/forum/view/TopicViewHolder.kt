package ru.endroad.feature.forum.view

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.forum_topic_item.view.answer
import kotlinx.android.synthetic.main.forum_topic_item.view.description
import kotlinx.android.synthetic.main.forum_topic_item.view.name
import ru.endroad.feature.forum.data.ForumItem
import ru.endroad.feature.forum.utils.inflate
import ru.endroad.houseadvice.feature.forum.R

internal class TopicViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(parent.inflate(R.layout.forum_topic_item)) {

	companion object{
		val type = R.id.forum_topic_item
	}

	fun bind(topic: ForumItem.Topic) {
		itemView.name.text = topic.name
		itemView.description.text = topic.desc
		itemView.answer.text = "ответов: ${topic.answerCount}"
	}
}