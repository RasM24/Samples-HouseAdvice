package ru.endroad.feature.onboard.view

import androidx.lifecycle.ViewModel
import ru.endroad.feature.onboard.data.OnBoardingAvailableDataSource
import ru.endroad.feature.onboard.di.OnBoardRouting

class OnBoardPresenter(
	private val onBoardingAvailableDataSource: OnBoardingAvailableDataSource,
	private val onBoardRouting: OnBoardRouting
) : ViewModel() {

	fun onClickSkip() {
		onBoardingAvailableDataSource.disableOnBoard()
		onBoardRouting.openStartScreen()
	}

	fun onClickGetStarted() {
		onBoardingAvailableDataSource.disableOnBoard()
		onBoardRouting.openStartScreen()
	}
}