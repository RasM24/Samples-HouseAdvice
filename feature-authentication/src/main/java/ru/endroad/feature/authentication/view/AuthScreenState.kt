package ru.endroad.feature.authentication.view

sealed class AuthScreenState {
	class Initialized(val isPhoneValidate: Boolean) : AuthScreenState()
	class VerifyCode(val isCodeValidate: Boolean) : AuthScreenState()
	object VerifySuccess : AuthScreenState()
}