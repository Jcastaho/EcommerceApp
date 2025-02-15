package com.straccion.ecommerce.domains.usecase.auth

import com.straccion.ecommerce.domains.repository.AuthRepository

class LogoutUseCase (private val repository: AuthRepository) {
    suspend operator fun invoke() = repository.logout()
}