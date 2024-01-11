package com.jorgerc.blogapp.domain.repository

import com.google.firebase.auth.FirebaseUser
import com.jorgerc.blogapp.domain.model.Response

interface AuthRepository {

    val currentUser: FirebaseUser?
    suspend fun login(email: String, password: String): Response<FirebaseUser>
}