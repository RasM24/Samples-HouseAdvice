package ru.endroad.houseadvice.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

interface NavigatorHolder {
	val container: Int
	var fragmentManager: FragmentManager?

	fun open(fragment: Fragment) = fragmentManager?.forwardTo(fragment, container)
	fun replace(fragment: Fragment) = fragmentManager?.replace(fragment, container)
	fun changeRoot(fragment: Fragment) = fragmentManager?.changeRoot(fragment, container)
	fun back() = fragmentManager?.back()
}