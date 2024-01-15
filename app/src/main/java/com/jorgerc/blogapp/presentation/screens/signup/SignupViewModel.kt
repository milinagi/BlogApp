package com.jorgerc.blogapp.presentation.screens.signup

import android.util.Patterns
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.jorgerc.blogapp.domain.model.Response
import com.jorgerc.blogapp.domain.model.User
import com.jorgerc.blogapp.domain.usecase.auth.AuthUseCases
import com.jorgerc.blogapp.domain.usecase.users.UsersUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(private val authUseCases: AuthUseCases, private val usersUseCases: UsersUseCases): ViewModel() {

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
    @set:JvmName("setConfirmPasswordString")
    var confirmPassword: MutableState<String> = mutableStateOf("")
    @set:JvmName("setIsConfirmPasswordString")
    var isConfirmPassword: MutableState<Boolean> = mutableStateOf(false)
    var confirmPasswordErrMsg: MutableState<String> = mutableStateOf("")

    private val _signupFlow = MutableStateFlow<Response<FirebaseUser>?>(null)
    val signupFlow: StateFlow<Response<FirebaseUser>?> = _signupFlow

    var user = User()

    fun onSignup() {
        user.username = username.value
        user.email = email.value
        user.password = password.value
        signup(user)
    }

    fun createUser() = viewModelScope.launch {
        user.id = authUseCases.getCurrentUser()!!.uid
        usersUseCases.create(user)
    }

    fun signup(user: User) = viewModelScope.launch {
        _signupFlow.value = Response.Loading
        val result = authUseCases.signup(user)
        _signupFlow.value = result
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

    fun enabledSignupButton() {
                    isEnabledSignupButton =
                    isEmailValid.value &&
                    isPasswordValid.value &&
                    isUsernameValid.value &&
                    isConfirmPassword.value
    }
}