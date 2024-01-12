package com.jorgerc.blogapp.presentation.screens.profile

import androidx.lifecycle.ViewModel
import com.jorgerc.blogapp.domain.usecase.auth.AuthUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModule @Inject constructor(private val authUseCases: AuthUseCases): ViewModel() {

    fun logout() {
        authUseCases.logout()
    }
}