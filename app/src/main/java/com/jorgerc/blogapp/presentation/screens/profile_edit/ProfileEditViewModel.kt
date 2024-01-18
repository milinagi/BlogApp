package com.jorgerc.blogapp.presentation.screens.profile_edit

import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jorgerc.blogapp.domain.model.Response
import com.jorgerc.blogapp.domain.model.User
import com.jorgerc.blogapp.domain.usecase.users.UsersUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileEditViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val usersUseCases: UsersUseCases
): ViewModel() {

    //STATE FORM
    var state by mutableStateOf(ProfileEditState())
        private set
    var usernameErrMsg by mutableStateOf("")
        private set

    val data = savedStateHandle.get<String>("user")
    val user = User.fromJson(data!!)

    var updateResponse by mutableStateOf<Response<Boolean>?>(null)
        private set

    // IMAGE
    var imageUri by mutableStateOf<Uri?>(null)
    var hasImage by mutableStateOf(false)

    init {
        state = state.copy(username = user.username)
    }

    fun onCameraResult(result: Boolean) {
        hasImage = result
    }
    fun onGalleryResult(uri: Uri?) {
        hasImage = uri != null
        imageUri = uri
    }

    fun onUpdate() {
        val myUser = User(
            id = user.id,
            username = state.username,
            image = ""
        )
        update(myUser)
    }
    fun update(user: User) = viewModelScope.launch {
        updateResponse = Response.Loading
        val result = usersUseCases.update(user)
        updateResponse = result
    }

    fun onUserNameInput(username: String) {
        state = state.copy(username = username)
    }
    fun validateUsername() {
        if (state.username.length >= 3) {
            usernameErrMsg = ""
        }
        else{
            usernameErrMsg = "Al menos 5 caracteres"
        }
    }
}