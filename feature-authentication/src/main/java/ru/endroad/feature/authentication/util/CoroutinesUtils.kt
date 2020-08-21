package ru.endroad.feature.authentication.util

import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.callbackFlow

internal val TextView.textChangeFlow: Flow<String>
	get() = callbackFlow<String> {
		val textWatcher = object : TextWatcher {
			override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
			override fun afterTextChanged(s: Editable?) {}
			override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
				offer(s?.toString() ?: "")
			}
		}
		addTextChangedListener(textWatcher)
		awaitClose { removeTextChangedListener(textWatcher) }
	}.buffer(Channel.CONFLATED)