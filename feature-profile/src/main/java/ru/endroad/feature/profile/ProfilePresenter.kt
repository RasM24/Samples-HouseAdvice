package ru.endroad.feature.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.endroad.shared.profile.Profile
import ru.endroad.shared.profile.ProfileDataSource

class ProfilePresenter(
	private val profileDataSource: ProfileDataSource
) : ViewModel() {

	val profileData = MutableLiveData<Profile>()

	init {
		viewModelScope.launch {
			val profile = profileDataSource.get()
			profileData.value = profile
		}
	}
}