package com.jorgerc.blogapp.presentation.screens.profile


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jorgerc.blogapp.domain.model.User
import com.jorgerc.blogapp.domain.usecase.auth.AuthUseCases
import com.jorgerc.blogapp.domain.usecase.users.UsersUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModule @Inject constructor(
    private val authUseCases: AuthUseCases,
    private val usersUseCases: UsersUseCases
): ViewModel() {

   var userData by mutableStateOf(User())
       private set

    val currentUser = authUseCases.getCurrentUser()

    init {
        getUserById()
    }
    private fun getUserById() = viewModelScope.launch {
        usersUseCases.getUserById(currentUser!!.uid).collect() {
            userData = it
        }
    }

    fun logout() {
        authUseCases.logout()
    }
}