package ru.endroad.houseadvice.deeplink

import android.net.Uri
import ru.endroad.feature.forum.view.ForumFragment
import ru.endroad.feature.onboard.view.OnBoardingFragment
import ru.endroad.feature.voting.view.VotingFragment
import ru.endroad.feature.voting.view.VotingFragment.Companion.setArgument
import ru.endroad.feature_information.BulletinBoardFragment
import ru.endroad.houseadvice.navigation.navigator.NavigatorHolder

class DeeplinkHandler(
	private val rootNavigatorHolder: NavigatorHolder,
	private val contentNavigatorHolder: NavigatorHolder
) {

	fun handle(deeplink: Uri) {
		when (deeplink.path) {
			"/forum"         -> contentNavigatorHolder.open(ForumFragment())
			"/bulletinboard" -> contentNavigatorHolder.open(BulletinBoardFragment())
			"/onboard"       -> rootNavigatorHolder.open(OnBoardingFragment())
			"/vote"          -> contentNavigatorHolder.open(VotingFragment().apply { setArgument(deeplink.questionId) })
		}
	}

	private val Uri.questionId
		get() = getQueryParameter("id")!!.toLong()
}