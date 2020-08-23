package ru.endroad.feature.onboard.data

import android.content.Context
import android.content.SharedPreferences

class OnBoardingAvailableDataSource(context: Context) {

	companion object {
		private const val IS_FIRST_TIME_LAUNCH = "IS_FIRST_TIME_LAUNCH"
		private const val PREF_NAME = "HOUSE_ADVICE_PREFERENCE"
	}

	private val preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
	private val editor: SharedPreferences.Editor = preferences.edit()

	fun isOnBoardAvailable() = preferences.getBoolean(IS_FIRST_TIME_LAUNCH, true)

	fun disableOnBoard() = editor.putBoolean(IS_FIRST_TIME_LAUNCH, false).apply()

	fun enableOnBoard() = editor.putBoolean(IS_FIRST_TIME_LAUNCH, true).apply()
}