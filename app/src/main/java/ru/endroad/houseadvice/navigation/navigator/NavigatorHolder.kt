package ru.endroad.houseadvice.navigation.navigator

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import ru.endroad.houseadvice.navigation.utils.back
import ru.endroad.houseadvice.navigation.utils.changeRoot
import ru.endroad.houseadvice.navigation.utils.forwardTo
import ru.endroad.houseadvice.navigation.utils.replace

interface NavigatorHolder {
	val container: Int
	var fragmentManager: FragmentManager?

	fun open(fragment: Fragment) = fragmentManager?.forwardTo(fragment, container)
	fun replace(fragment: Fragment) = fragmentManager?.replace(fragment, container)
	fun changeRoot(fragment: Fragment) = fragmentManager?.changeRoot(fragment, container)
	fun back() = fragmentManager?.back()
}