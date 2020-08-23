package ru.endroad.feature.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.profile_fragment.profile_address
import kotlinx.android.synthetic.main.profile_fragment.profile_flat_area
import kotlinx.android.synthetic.main.profile_fragment.profile_flat_number
import kotlinx.android.synthetic.main.profile_fragment.profile_name
import kotlinx.android.synthetic.main.profile_fragment.profile_percent_of_vote
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.endroad.houseadvice.feature.profile.R
import ru.endroad.shared.profile.Profile

class ProfileFragment : Fragment() {

	private val presenter: ProfilePresenter by viewModel()

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
		inflater.inflate(R.layout.profile_fragment, container, false)

	override fun onActivityCreated(savedInstanceState: Bundle?) {
		super.onActivityCreated(savedInstanceState)
		requireActivity().title = "Профиль"

		presenter.profileData.observe(viewLifecycleOwner, Observer { renderProfile(it) })
	}

	private fun renderProfile(profile: Profile) {
		profile_name.text = profile.userName
		profile_flat_number.text = "квартира: ${profile.flat.number}"
		profile_address.text = profile.flat.address
		profile_flat_area.text = "площадь: ${profile.flat.apartmentArea}к.м."
		profile_percent_of_vote.text = "2.3%"
	}
}