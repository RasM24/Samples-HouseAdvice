package ru.endroad.feature.voting.view

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.voting_layout.voting_abstained
import kotlinx.android.synthetic.main.voting_layout.voting_information
import kotlinx.android.synthetic.main.voting_layout.voting_no
import kotlinx.android.synthetic.main.voting_layout.voting_title
import kotlinx.android.synthetic.main.voting_layout.voting_yes
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.endroad.feature.voting.R

class VotingFragment : Fragment() {

	private val presenter: VotingPresenter by viewModel()

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
		inflater.inflate(R.layout.voting_layout, container, false)

	override fun onActivityCreated(savedInstanceState: Bundle?) {
		super.onActivityCreated(savedInstanceState)

		voting_yes.setOnClickListener { presenter.onYesClick() }
		voting_no.setOnClickListener { presenter.onNoClick() }
		voting_abstained.setOnClickListener { presenter.onAbstainedClick() }

		presenter.screenState.observe(viewLifecycleOwner, Observer { render(it) })
	}

	private fun render(screenState: VotingScreenState) {
		when (screenState) {
			is VotingScreenState.Data -> renderData(screenState)
		}
	}

	private fun renderData(state: VotingScreenState.Data) {
		voting_title.text = state.title
		voting_information.text = state.information

		//TODO кривая реализация. При смене голоса будет аффектится
		when (state.vote) {
			VOTE.YES       -> {
				voting_yes.setBackgroundColor(Color.GREEN)
				voting_no.isEnabled = false
				voting_abstained.isEnabled = false
			}

			VOTE.NO        -> {
				voting_no.setBackgroundColor(Color.GREEN)
				voting_yes.isEnabled = false
				voting_abstained.isEnabled = false
			}

			VOTE.ABSTAINED -> {
				voting_abstained.setBackgroundColor(Color.GREEN)
				voting_no.isEnabled = false
				voting_yes.isEnabled = false
			}

			VOTE.NO_VOTE   -> {
			}
		}
	}
}