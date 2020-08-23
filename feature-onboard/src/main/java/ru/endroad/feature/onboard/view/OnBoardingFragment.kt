package ru.endroad.feature.onboard.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.onboarding_fragment.on_board
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.endroad.houseadvice.feature.onboard.R

class OnBoardingFragment : Fragment() {

	private val presenter: OnBoardPresenter by viewModel()

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
		inflater.inflate(R.layout.onboarding_fragment, container, false)

	override fun onActivityCreated(savedInstanceState: Bundle?) {
		super.onActivityCreated(savedInstanceState)

		on_board.setClickOnSkipListener(presenter::onClickSkip)
		on_board.onClickStartedListener(presenter::onClickGetStarted)
	}
}