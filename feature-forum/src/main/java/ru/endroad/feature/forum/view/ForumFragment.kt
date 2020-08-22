package ru.endroad.feature.forum.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.forum_fragment.recyclerView
import ru.endroad.feature.forum.R
import ru.endroad.feature.forum.data.ForumDataSource

class ForumFragment : Fragment() {

	private var itemListAdapter = ForumListAdapter()

	//TODO неправильно. Сделано исключительно для mock-скрина
	private val forumDataSource = ForumDataSource()

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
		inflater.inflate(R.layout.forum_fragment, container, false)

	override fun onActivityCreated(savedInstanceState: Bundle?) {
		super.onActivityCreated(savedInstanceState)

		recyclerView.adapter = itemListAdapter

		itemListAdapter.setList(forumDataSource.get())
	}
}