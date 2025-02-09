package com.straccion.ecommerce.domains.usecase.auth

import com.straccion.ecommerce.domains.model.User
import com.straccion.ecommerce.domains.repository.AuthRepository

class UpdateSessionUseCase constructor(private val repository: AuthRepository) {
    suspend operator fun invoke(user: User) = repository.updateSession(user)
}