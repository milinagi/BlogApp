package com.jorgerc.blogapp.di

import com.google.firebase.auth.FirebaseAuth
import com.jorgerc.blogapp.data.repository.AuthRepositoryImpl
import com.jorgerc.blogapp.domain.repository.AuthRepository
import com.jorgerc.blogapp.domain.usecase.auth.AuthUseCases
import com.jorgerc.blogapp.domain.usecase.auth.GetCurrentUser
import com.jorgerc.blogapp.domain.usecase.auth.Login
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Provides
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    fun provideAuthRepository(impl: AuthRepositoryImpl): AuthRepository = impl

    @Provides
    fun provideAuthUseCases(repository: AuthRepository) = AuthUseCases(
        getCurrentUser = GetCurrentUser(repository),
        login = Login(repository)
    )
}