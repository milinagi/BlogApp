package com.jorgerc.blogapp.domain.usecase.users

import com.jorgerc.blogapp.domain.repository.UsersRepository
import javax.inject.Inject

class GetUserById @Inject constructor(private val repository: UsersRepository) {

    operator fun invoke(id: String) = repository.getUserById(id)

}
