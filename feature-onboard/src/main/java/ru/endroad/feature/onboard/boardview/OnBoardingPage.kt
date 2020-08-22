package ru.endroad.feature.onboard.boardview

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import ru.endroad.houseadvice.feature.onboard.R

enum class OnBoardingPage(
	@StringRes val titleResource: Int,
	@StringRes val subTitleResource: Int,
	@StringRes val descriptionResource: Int,
	@DrawableRes val logoResource: Int
) {

	ONE(
		R.string.onboarding_slide1_title,
		R.string.onboarding_slide1_subtitle,
		R.string.onboarding_slide1_desc,
		R.drawable.ic_hang_out
	),

	TWO(
		R.string.onboarding_slide2_title,
		R.string.onboarding_slide2_subtitle,
		R.string.onboarding_slide2_desc,
        R.drawable.ic_directions
	),

	THREE(
		R.string.onboarding_slide3_title,
		R.string.onboarding_slide3_subtitle,
		R.string.onboarding_slide3_desc,
		R.drawable.ic_a_day_at_the_park
	)

}