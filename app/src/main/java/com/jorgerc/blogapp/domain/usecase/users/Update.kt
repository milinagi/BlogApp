package com.jorgerc.blogapp.domain.usecase.users

import com.jorgerc.blogapp.domain.model.User
import com.jorgerc.blogapp.domain.repository.UsersRepository
import javax.inject.Inject

class Update @Inject constructor(private val repository: UsersRepository) {

    suspend operator fun invoke(user: User) = repository.update(user)

}
