package com.jorgerc.blogapp.data.repository

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.toObject
import com.jorgerc.blogapp.domain.model.Response
import com.jorgerc.blogapp.domain.model.User
import com.jorgerc.blogapp.domain.repository.UsersRepository
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class UsersRepositoryImpl @Inject constructor(private val usersRef: CollectionReference): UsersRepository {
    override suspend fun create(user: User): Response<Boolean> {

        return try {
            user.password = ""
            usersRef.document(user.id).set(user).await()
            Response.Success(true)
        } catch (e: Exception) {
            e.printStackTrace()
            Response.Failure(e)
        }
    }

    override fun getUserById(id: String): Flow<User> = callbackFlow {
        val snapshotListener = usersRef.document(id).addSnapshotListener { snapshot, e ->
            val user = snapshot?.toObject(User::class.java) ?: User()
            trySend(user)
        }

        awaitClose {
            snapshotListener.remove()
        }
    }
}