package ru.endroad.feature.question.list.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import java.text.SimpleDateFormat
import java.util.Date

private const val SECOND_IN_DAY = 86400
private const val MILLIS_IN_SECOND = 1000

//TODO дубляж
internal fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View =
	LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)

internal fun formatDate(unix: Long): String {
	val format = SimpleDateFormat("dd MMM, E")

	val date = Date(unix)
	return format.format(date)
}

internal fun getLeftCountDaysTo(endDate: Long): Int {
	val startDate = Date().time / MILLIS_IN_SECOND

	return ((endDate - startDate) / 86400).toInt()
}