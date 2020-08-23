package ru.endroad.feature.support

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.support_fragment.tszh_phone
import kotlinx.android.synthetic.main.support_fragment.zhkh_phone
import ru.endroad.houseadvice.feature.support.R

class SupportFragment : Fragment() {

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
		inflater.inflate(R.layout.support_fragment, container, false)

	override fun onActivityCreated(savedInstanceState: Bundle?) {
		super.onActivityCreated(savedInstanceState)
		requireActivity().title = "Связь с ТСЖ/ЖКХ"

		tszh_phone.text = "УК Ленинская: 349-95-37"
		zhkh_phone.text = "Горячая линия ЖКХ: 0-800-507-309"
	}
}