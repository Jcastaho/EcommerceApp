package com.straccion.ecommerce.domains.usecase.auth

import com.straccion.ecommerce.domains.repository.AuthRepository

class LoginUseCase(private val repository: AuthRepository) {
    suspend operator fun invoke(email: String, password: String) = repository.login(email, password)
}