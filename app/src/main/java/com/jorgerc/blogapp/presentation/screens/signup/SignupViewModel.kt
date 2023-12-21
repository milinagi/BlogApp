package com.jorgerc.blogapp.presentation.screens.signup

import android.util.Patterns
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(): ViewModel() {

    // USERNAME
    var username: MutableState<String> = mutableStateOf("")
    var isUsernameValid: MutableState<Boolean> = mutableStateOf(false)
    var usernameErrMsg: MutableState<String> = mutableStateOf("")

    // EMAIL
    var email: MutableState<String> = mutableStateOf("")
    var isEmailValid: MutableState<Boolean> = mutableStateOf(false)
    var emailErrMsg: MutableState<String> = mutableStateOf("")

    // PASSWORD
    var password: MutableState<String> = mutableStateOf("")
    var isPasswordValid: MutableState<Boolean> = mutableStateOf(false)
    var passwordErrMsg: MutableState<String> = mutableStateOf("")

    // ENABLE BUTTON
    var isEnabledSignupButton = false

    // CONFIRMAR CONTRASENA
    var confirmPassword: MutableState<String> = mutableStateOf("")
    var isConfirmPassword: MutableState<Boolean> = mutableStateOf(false)
    var confirmPasswordErrMsg: MutableState<String> = mutableStateOf("")



    fun validateConfirmPassword() {
        if (password.value == confirmPassword.value) {
            isConfirmPassword.value = true
            confirmPasswordErrMsg.value = ""
        }
        else {
            isConfirmPassword.value = false
            confirmPasswordErrMsg.value = "Las contraseña no coinciden"
        }
        enabledSignupButton()
    }
    fun validateUsername() {
        if (username.value.length >= 5) {
            isUsernameValid.value = true
            usernameErrMsg.value = ""
        }
        else{
            isUsernameValid.value = false
            usernameErrMsg.value = "Al menos 5 caracteres"
        }
        enabledSignupButton()
    }
    fun enabledSignupButton() {
        isEnabledSignupButton =
                isEmailValid.value &&
                isPasswordValid.value &&
                isUsernameValid.value &&
                isConfirmPassword.value
    }
    fun validateEmail() {
        if (Patterns.EMAIL_ADDRESS.matcher(email.value).matches()) {
            isEmailValid.value = true
            emailErrMsg.value = ""
        }
        else {
            isEmailValid.value = false
            emailErrMsg.value = "El email no es valido"
        }
        enabledSignupButton()
    }

    fun validatePassword() {
        if (password.value.length >= 6) {
            isPasswordValid.value = true
            passwordErrMsg.value = ""
        }
        else {
            isPasswordValid.value = false
            passwordErrMsg.value = "Al menos 6 caracteres"
        }
        enabledSignupButton()
    }
}