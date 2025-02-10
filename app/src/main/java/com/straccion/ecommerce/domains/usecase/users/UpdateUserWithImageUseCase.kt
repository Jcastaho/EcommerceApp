package com.straccion.ecommerce.domains.usecase.users

import com.straccion.ecommerce.domains.model.User
import com.straccion.ecommerce.domains.repository.UsersRepository
import java.io.File


class UpdateUserWithImageUseCase (val repository: UsersRepository) {

    suspend operator fun invoke(id: String, user: User, file: File) =
        repository.updateWithImage(id, user, file)
}