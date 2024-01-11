package com.jorgerc.blogapp.domain.usecase.auth

data class AuthUseCases (
    val getCurrentUser: GetCurrentUser,
    val login: Login
)

