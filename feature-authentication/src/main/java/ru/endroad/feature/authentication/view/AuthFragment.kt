package ru.endroad.feature.authentication.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.authentication_fragment.input_code
import kotlinx.android.synthetic.main.authentication_fragment.input_layout_code
import kotlinx.android.synthetic.main.authentication_fragment.input_layout_phone
import kotlinx.android.synthetic.main.authentication_fragment.input_phone
import kotlinx.android.synthetic.main.authentication_fragment.resend
import kotlinx.android.synthetic.main.authentication_fragment.sign_phone
import kotlinx.android.synthetic.main.authentication_fragment.text_agreement
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.endroad.houseadvice.feature.authentication.R

//TODO hardcode ресурсов
class AuthFragment : Fragment() {

	private val presenter: AuthPresenter by viewModel()

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
		inflater.inflate(R.layout.authentication_fragment, container, false)

	override fun onActivityCreated(savedInstanceState: Bundle?) {
		super.onActivityCreated(savedInstanceState)

		presenter.state.observe(viewLifecycleOwner, Observer { render(it) })

		presenter.bindInputCodeWatcher(input_code)
		presenter.bindInputPhoneWatcher(input_phone)
	}

	private fun render(screenState: AuthScreenState) {
		when (screenState) {
			is AuthScreenState.Initialized   -> {
				enableViews(input_layout_phone, sign_phone, text_agreement)
				disableViews(resend, input_layout_code)
				sign_phone.text = "Отправить код"
				sign_phone.isEnabled = screenState.isPhoneValidate
				sign_phone.setOnClickListener { presenter.onClickSendOtp() }
			}

			is AuthScreenState.VerifyCode    -> {
				enableViews(input_layout_phone, input_layout_code, sign_phone, resend, text_agreement)
				sign_phone.text = "Войти"
				sign_phone.isEnabled = screenState.isCodeValidate
				sign_phone.setOnClickListener { presenter.onClickSign() }
			}

			is AuthScreenState.VerifySuccess -> {
				//TODO
			}
		}
	}

	private fun enableViews(vararg views: View) = views.forEach { it.visibility = View.VISIBLE }

	private fun disableViews(vararg views: View) = views.forEach { it.visibility = View.GONE }
}
