package com.straccion.ecommerce.domains.usecase.users

import com.straccion.ecommerce.domains.model.User
import com.straccion.ecommerce.domains.repository.UsersRepository


class UpdateUserUseCase constructor(val repository: UsersRepository) {

    suspend operator fun invoke(id: String, user: User) = repository.update(id, user)
}