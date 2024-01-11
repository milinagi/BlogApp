package com.jorgerc.blogapp.domain.usecase.auth

import com.jorgerc.blogapp.data.repository.AuthRepositoryImpl
import com.jorgerc.blogapp.domain.repository.AuthRepository
import javax.inject.Inject

class Login @Inject constructor(private val repository: AuthRepository) {

    suspend operator fun invoke(email: String, password: String) = repository.login(email, password)
}