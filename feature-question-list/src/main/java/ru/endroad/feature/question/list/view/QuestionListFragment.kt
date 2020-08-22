package ru.endroad.feature.question.list.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.question_list_fragment.recyclerView
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.endroad.feature.question.list.presenter.QuestionListViewModel
import ru.endroad.houseadvice.feature.question.list.R

class QuestionListFragment : Fragment() {

	private val presenter: QuestionListViewModel by viewModel()

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
		inflater.inflate(R.layout.question_list_fragment, container, false)

	override fun onActivityCreated(savedInstanceState: Bundle?) {
		super.onActivityCreated(savedInstanceState)

		val itemListAdapter = QuestionListAdapter(
			presenter::onCLickSoonQuestion,
			presenter::onCLickOpenQuestion,
			presenter::onCLickCompletedQuestion
		)

		recyclerView.adapter = itemListAdapter
		presenter.questionList.observe(viewLifecycleOwner, Observer {
			itemListAdapter.setList(it)
		})
	}
}