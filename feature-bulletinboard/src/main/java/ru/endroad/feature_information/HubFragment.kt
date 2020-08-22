package ru.endroad.feature_information

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.bulletin_board_fragment.first_announcement_title
import kotlinx.android.synthetic.main.bulletin_board_fragment.second_announcement_title
import kotlinx.android.synthetic.main.bulletin_board_fragment.third_announcement_title
import ru.endroad.houseadvice.feature_information.R

class BulletinBoardFragment : Fragment() {

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
		inflater.inflate(R.layout.bulletin_board_fragment, container, false)

	override fun onActivityCreated(savedInstanceState: Bundle?) {
		super.onActivityCreated(savedInstanceState)

		//TODO hardcore дата, так как экран заглушка
		first_announcement_title.text = "Внимание! Будет производится отключение воды с 21.05.2020 по 27.05.2020"
		second_announcement_title.text = "Список должников:\n" +
			"78кв: 4033\n" +
			"54кв: 1р\n" +
			"129кв: 69493р"
		third_announcement_title.text = "Сбор жильцов для голосования в 12.00 21 января"
	}
}