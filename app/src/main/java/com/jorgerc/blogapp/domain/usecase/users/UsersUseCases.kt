package com.jorgerc.blogapp.domain.usecase.users

data class UsersUseCases(
    val create: Create,
    val getUserById: GetUserById,
    val update: Update
)
