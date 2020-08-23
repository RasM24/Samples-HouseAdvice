package ru.endroad.feature.onboard.boardview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import androidx.viewpager2.widget.ViewPager2
import ru.endroad.feature.onboard.boardview.OnBoardingPagerAdapter
import ru.endroad.feature.onboard.boardview.OnBoardingPage
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator
import kotlinx.android.synthetic.main.onboarding_view.view.nextBtn
import kotlinx.android.synthetic.main.onboarding_view.view.onboardingRoot
import kotlinx.android.synthetic.main.onboarding_view.view.skipBtn
import kotlinx.android.synthetic.main.onboarding_view.view.slider
import kotlinx.android.synthetic.main.onboarding_view.view.startBtn
import ru.endroad.feature.onboard.R
import setParallaxTransformation

class OnBoardingView @JvmOverloads
constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0, defStyleRes: Int = 0) :
	FrameLayout(context, attrs, defStyleAttr, defStyleRes) {

	private val numberOfPages by lazy { OnBoardingPage.values().size }

	private var onClickSkipListener: () -> Unit = {}
	private var onClickStartedListener: () -> Unit = {}

	init {
		val view = LayoutInflater.from(context).inflate(R.layout.onboarding_view, this, true)
		setUpSlider(view)
		addingButtonsClickListeners()
	}

	fun setClickOnSkipListener(onClickSkipListener: () -> Unit) {
		this.onClickSkipListener = onClickSkipListener
	}

	fun onClickStartedListener(onClickStartedListener: () -> Unit) {
		this.onClickStartedListener = onClickStartedListener
	}

	private fun setUpSlider(view: View) {
		with(slider) {
			adapter = OnBoardingPagerAdapter()
			setPageTransformer { page, position ->
				setParallaxTransformation(page, position)
			}

			addSlideChangeListener()

			val wormDotsIndicator = view.findViewById<WormDotsIndicator>(R.id.page_indicator)
			wormDotsIndicator.setViewPager2(this)
		}
	}

	private fun addSlideChangeListener() {
		slider.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
			override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
				super.onPageScrolled(position, positionOffset, positionOffsetPixels)
				if (numberOfPages > 1) {
					val newProgress = (position + positionOffset) / (numberOfPages - 1)
					onboardingRoot.progress = newProgress
				}
			}
		})
	}

	private fun addingButtonsClickListeners() {
		nextBtn.setOnClickListener { navigateToNextSlide() }
		skipBtn.setOnClickListener { onClickSkipListener() }
		startBtn.setOnClickListener { onClickStartedListener() }
	}

	private fun navigateToNextSlide() {
		val nextSlidePos: Int = slider?.currentItem?.plus(1) ?: 0
		slider?.setCurrentItem(nextSlidePos, true)
	}
}