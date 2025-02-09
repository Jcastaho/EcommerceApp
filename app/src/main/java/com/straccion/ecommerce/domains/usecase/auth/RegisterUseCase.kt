package com.straccion.ecommerce.domains.usecase.auth

import com.straccion.ecommerce.domains.model.User
import com.straccion.ecommerce.domains.repository.AuthRepository

class RegisterUseCase(private val repository: AuthRepository) {
    suspend operator fun invoke(user: User) =  repository.register(user)
}