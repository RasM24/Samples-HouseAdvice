package ru.endroad.feature.onboard.boardview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.onboarding_page_item.view.onboard_description
import kotlinx.android.synthetic.main.onboarding_page_item.view.onboard_image
import kotlinx.android.synthetic.main.onboarding_page_item.view.onboard_subtitle
import kotlinx.android.synthetic.main.onboarding_page_item.view.onboard_title
import ru.endroad.feature.onboard.R

class OnBoardingPagerAdapter(
	private val onBoardingPageList: Array<OnBoardingPage> = OnBoardingPage.values()
) : RecyclerView.Adapter<PagerViewHolder>() {

	override fun onCreateViewHolder(parent: ViewGroup, p1: Int): PagerViewHolder {
		return LayoutInflater.from(parent.context).inflate(PagerViewHolder.LAYOUT, parent, false).let {
			PagerViewHolder(it)
		}
	}

	override fun getItemCount() = onBoardingPageList.size

	override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
		holder.bind(onBoardingPageList[position])
	}
}

class PagerViewHolder(private val root: View) : RecyclerView.ViewHolder(root) {
	fun bind(onBoardingPage: OnBoardingPage) {
		val res = root.context.resources
		root.onboard_title?.text = res.getString(onBoardingPage.titleResource)
		root.onboard_subtitle?.text = res.getString(onBoardingPage.subTitleResource)
		root.onboard_description?.text = res.getString(onBoardingPage.descriptionResource)
		root.onboard_image.setImageResource(onBoardingPage.logoResource)
	}

	companion object {
		@LayoutRes
		val LAYOUT = R.layout.onboarding_page_item
	}
}