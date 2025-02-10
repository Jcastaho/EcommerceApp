package com.straccion.ecommerce.domains.usecase.auth

import com.straccion.ecommerce.domains.model.AuthResponse
import com.straccion.ecommerce.domains.repository.AuthRepository

class SaveSessionUseCase (private val repository: AuthRepository) {
    suspend operator fun invoke(authResponse: AuthResponse) = repository.saveSession(authResponse)
}