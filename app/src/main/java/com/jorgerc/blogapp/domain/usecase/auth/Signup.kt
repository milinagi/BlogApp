package com.jorgerc.blogapp.domain.usecase.auth

import com.jorgerc.blogapp.domain.model.User
import com.jorgerc.blogapp.domain.repository.AuthRepository
import javax.inject.Inject

class Signup @Inject constructor(private val repository: AuthRepository) {

    suspend operator fun invoke(user: User) = repository.signUp(user)

}
