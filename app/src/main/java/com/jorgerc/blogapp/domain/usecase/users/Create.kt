package com.jorgerc.blogapp.domain.usecase.users

import com.jorgerc.blogapp.domain.model.User
import com.jorgerc.blogapp.domain.repository.UsersRepository
import javax.inject.Inject

class Create @Inject constructor(private val repository: UsersRepository) {

    suspend operator fun invoke(user: User) = repository.create(user)

}
