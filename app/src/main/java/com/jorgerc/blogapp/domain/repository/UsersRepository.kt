package com.jorgerc.blogapp.domain.repository

import com.jorgerc.blogapp.domain.model.Response
import com.jorgerc.blogapp.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UsersRepository {

    suspend fun create(user: User): Response<Boolean>
    suspend fun update(user: User): Response<Boolean>
    fun getUserById(id: String): Flow<User>
}