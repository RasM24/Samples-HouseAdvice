package ru.endroad.houseadvice.navigation.navigator

import androidx.annotation.IdRes
import androidx.fragment.app.FragmentManager

class RootNavigator(@IdRes override val container: Int) : NavigatorHolder {
	override var fragmentManager: FragmentManager? = null
}