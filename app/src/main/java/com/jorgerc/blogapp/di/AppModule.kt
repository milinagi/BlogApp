package com.jorgerc.blogapp.di

import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.jorgerc.blogapp.core.Constants.USERS
import com.jorgerc.blogapp.data.repository.AuthRepositoryImpl
import com.jorgerc.blogapp.data.repository.UsersRepositoryImpl
import com.jorgerc.blogapp.domain.repository.AuthRepository
import com.jorgerc.blogapp.domain.repository.UsersRepository
import com.jorgerc.blogapp.domain.usecase.auth.AuthUseCases
import com.jorgerc.blogapp.domain.usecase.auth.GetCurrentUser
import com.jorgerc.blogapp.domain.usecase.auth.Login
import com.jorgerc.blogapp.domain.usecase.auth.Logout
import com.jorgerc.blogapp.domain.usecase.auth.Signup
import com.jorgerc.blogapp.domain.usecase.users.Create
import com.jorgerc.blogapp.domain.usecase.users.GetUserById
import com.jorgerc.blogapp.domain.usecase.users.SaveImage
import com.jorgerc.blogapp.domain.usecase.users.Update
import com.jorgerc.blogapp.domain.usecase.users.UsersUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    fun provideFirebaseFirestore(): FirebaseFirestore = Firebase.firestore

    @Provides
    fun provideFirebaseStorage(): FirebaseStorage = FirebaseStorage.getInstance()

    @Provides
    fun provideStorageUsersRef(storage: FirebaseStorage): StorageReference = storage.reference.child(USERS)

    @Provides
    fun provideUsersRef(db: FirebaseFirestore): CollectionReference = db.collection(USERS)

    @Provides
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    fun provideAuthRepository(impl: AuthRepositoryImpl): AuthRepository = impl

    @Provides
    fun provideUsersRepository(impl: UsersRepositoryImpl): UsersRepository = impl

    @Provides
    fun provideAuthUseCases(repository: AuthRepository) = AuthUseCases(
        getCurrentUser = GetCurrentUser(repository),
        login = Login(repository),
        logout = Logout(repository),
        signup = Signup(repository)
    )

    @Provides
    fun provideUsersUseCases(repository: UsersRepository) = UsersUseCases(
        create = Create(repository),
        getUserById = GetUserById(repository),
        update = Update(repository),
        saveImage = SaveImage(repository)
    )
}
