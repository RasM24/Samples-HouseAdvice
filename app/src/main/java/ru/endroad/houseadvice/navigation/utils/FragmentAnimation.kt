package ru.endroad.houseadvice.navigation.utils

import androidx.annotation.AnimRes
import androidx.annotation.AnimatorRes
import ru.endroad.houseadvice.R

data class FragmentAnimation(
	@AnimRes @AnimatorRes val enter: Int,
	@AnimRes @AnimatorRes val exit: Int,
	@AnimRes @AnimatorRes val popEnter: Int,
	@AnimRes @AnimatorRes val popExit: Int
)

val forwardAnimation = FragmentAnimation(
	R.anim.slide_in_right,
	R.anim.slide_out_left,
	R.anim.slide_in_left,
	R.anim.slide_out_right
)
val replaceAnimation = FragmentAnimation(
	R.anim.fade_in,
	R.anim.fade_out,
	R.anim.fade_in,
	R.anim.fade_out
)