package ru.endroad.feature.authentication.view

import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.endroad.feature.authentication.data.OtpDataSource
import ru.endroad.feature.authentication.util.textChangeFlow

class AuthPresenter(
	private val otpDataSource: OtpDataSource
) : ViewModel() {

	val state = MutableLiveData<AuthScreenState>()

	private var phoneNumber = ""
	private var verifyCode = ""

	init { //TODO рефакторить
		state.value = AuthScreenState.Initialized(isPhoneValidate = false)
	}

//	override fun bindSignPhoneClick(clickEvents: ReceiveChannel<Unit>) = bindEvent(clickEvents) {
//		when (state.value) {
//			is OnInitialized -> accountManager.phoneProvider.startPhoneNumberVerification(phoneNumber)
//			is OnVerifyCode  -> verifyPhoneNumberWithCode(verifyCode)
//		}
//	}

//	override fun bindResendCode(clickEvents: ReceiveChannel<Unit>) = bindEvent(clickEvents) {
//		onClickResend(phoneNumber)
//	}

	//TODO presenter не должен тянуть зависимости Android
	fun bindInputCodeWatcher(codeInputView: TextView) {
		viewModelScope.launch {
			codeInputView.textChangeFlow
				.collect {
					verifyCode = it
					//TODO вынести проверку в валидатор
					state.value = AuthScreenState.VerifyCode(isCodeValidate = verifyCode.length == 6)
				}
		}
	}

	//TODO presenter не должен тянуть зависимости Android
	fun bindInputPhoneWatcher(phoneInputView: TextView) {
		viewModelScope.launch {
			phoneInputView.textChangeFlow
				.collect {
					phoneNumber = it
					//TODO вынести проверку в валидатор
					state.value = AuthScreenState.Initialized(isPhoneValidate = verifyCode.length == 12)
				}
		}
	}

//	private fun onClickResend(phoneNumber: String) {
//		accountManager.phoneProvider.resendVerificationCode(phoneNumber)
//	}
//
//	private fun verifyPhoneNumberWithCode(code: String) {
//		val credential = accountManager.phoneProvider.login(code)
//		accountManager.login(credential, Provider.PHONE) {
//			mState.value = OnVerifySuccess
//		}
//	}

	fun onClickSendOtp() {
		viewModelScope.launch {
			otpDataSource.sendOtp()
		}
	}

	fun onClickResendCode() {
	}

	fun onClickSign() {

	}
}