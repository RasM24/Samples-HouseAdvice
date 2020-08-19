package ru.endroad.houseadvice.navigation

import androidx.annotation.IdRes
import androidx.fragment.app.FragmentManager

class NavigatorHolder(@IdRes val container: Int) {

	var fragmentManager: FragmentManager? = null
}