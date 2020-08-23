package ru.endroad.houseadvice.deeplink

import android.net.Uri
import androidx.fragment.app.Fragment
import ru.endroad.houseadvice.navigation.navigator.NavigatorHolder

class DeeplinkHandler(private val navigatorHolder: NavigatorHolder) {

	fun handle(deeplink: Uri) {
		val fragment = deeplink.path?.let(::resolveFragment)

		fragment?.let(navigatorHolder::open)
	}

	private fun resolveFragment(screen: String): Fragment? = null
}