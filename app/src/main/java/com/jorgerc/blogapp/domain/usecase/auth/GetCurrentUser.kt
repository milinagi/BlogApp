package com.jorgerc.blogapp.domain.usecase.auth

import com.jorgerc.blogapp.domain.repository.AuthRepository
import javax.inject.Inject

class GetCurrentUser @Inject constructor(private val repository: AuthRepository) {

    operator fun invoke() = repository.currentUser
}