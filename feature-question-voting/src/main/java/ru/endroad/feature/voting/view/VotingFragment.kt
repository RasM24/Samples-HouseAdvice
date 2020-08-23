package ru.endroad.feature.voting.view

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.voting_layout.voting_abstained
import kotlinx.android.synthetic.main.voting_layout.voting_discussion
import kotlinx.android.synthetic.main.voting_layout.voting_information
import kotlinx.android.synthetic.main.voting_layout.voting_no
import kotlinx.android.synthetic.main.voting_layout.voting_screen
import kotlinx.android.synthetic.main.voting_layout.voting_title
import kotlinx.android.synthetic.main.voting_layout.voting_yes
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import ru.endroad.houseadvice.feature.voting.R
import ru.endroad.shared.voting.model.QuestionStatus
import ru.endroad.shared.voting.model.Vote

class VotingFragment : Fragment() {

	companion object {
		private const val QUESTION_ID = "QUESTION_ID"

		fun VotingFragment.setArgument(questionId: Long) {
			arguments = bundleOf(QUESTION_ID to questionId)
		}
	}

	private val questionId: Long by lazy { checkNotNull(arguments?.getLong(QUESTION_ID)) }

	private val presenter: VotingPresenter by viewModel { parametersOf(questionId) }

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
		inflater.inflate(R.layout.voting_layout, container, false)

	override fun onActivityCreated(savedInstanceState: Bundle?) {
		super.onActivityCreated(savedInstanceState)

		voting_yes.setOnClickListener { presenter.onYesClick() }
		voting_no.setOnClickListener { presenter.onNoClick() }
		voting_abstained.setOnClickListener { presenter.onAbstainedClick() }
		voting_discussion.setOnClickListener {
			//TODO добавить реальный переход на нужный экран
			Snackbar.make(voting_screen, "Здесь должен был открыться форум", Snackbar.LENGTH_LONG).show()
		}

		presenter.screenState.observe(viewLifecycleOwner, Observer { render(it) })
	}

	private fun render(screenState: VotingScreenState) {
		when (screenState) {
			is VotingScreenState.Data -> renderData(screenState)
		}
	}

	private fun renderData(state: VotingScreenState.Data) {
		voting_title.text = state.data.title
		voting_information.text = state.data.information

		if (state.data.status == QuestionStatus.SOON) {
			voting_abstained.isEnabled = false
			voting_no.isEnabled = false
			voting_yes.isEnabled = false
		} else {
			//TODO кривая реализация. При смене голоса будет аффектится
			when (state.vote) {
				Vote.YES       -> {
					voting_yes.setBackgroundColor(Color.GREEN)
					voting_no.isEnabled = false
					voting_abstained.isEnabled = false
				}

				Vote.NO        -> {
					voting_no.setBackgroundColor(Color.GREEN)
					voting_yes.isEnabled = false
					voting_abstained.isEnabled = false
				}

				Vote.ABSTAINED -> {
					voting_abstained.setBackgroundColor(Color.GREEN)
					voting_no.isEnabled = false
					voting_yes.isEnabled = false
				}

				Vote.NO_VOTE   -> {
				}
			}
		}
	}
}