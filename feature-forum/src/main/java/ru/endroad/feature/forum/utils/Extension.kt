package ru.endroad.feature.forum.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

//TODO дубляж
internal fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View =
	LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)