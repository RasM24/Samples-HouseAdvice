package ru.endroad.feature.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.hub_fragment.navigation
import org.koin.android.ext.android.inject
import ru.endroad.houseadvice.feature.navigation.R

class HubFragment : Fragment() {

	//TODO развитии - вынести в presenter
	private val router: HubNavigationRouter by inject()

	//TODO initialTab должен определяться только в одном месте и приходить в этот класс извне
	private val initialTab = R.id.tab_votes

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
		inflater.inflate(R.layout.hub_fragment, container, false)

	override fun onActivityCreated(savedInstanceState: Bundle?) {
		super.onActivityCreated(savedInstanceState)

		navigation.selectedItemId = initialTab

		navigation.setOnNavigationItemSelectedListener { menu ->
			if (navigation.selectedItemId == menu.itemId) return@setOnNavigationItemSelectedListener false

			when (menu.itemId) {
				R.id.tab_forum       -> router.openForum()
				R.id.tab_information -> router.openInformation()
				R.id.tab_profile     -> router.openProfile()
				R.id.tab_support     -> router.openSupport()
				R.id.tab_votes       -> router.openVotes()
				else                 -> return@setOnNavigationItemSelectedListener false
			}
			true
		}
	}
}