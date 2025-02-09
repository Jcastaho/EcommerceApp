package com.straccion.ecommerce.domains.usecase.auth

import com.straccion.ecommerce.domains.repository.AuthRepository

class GetSessionDataUseCase constructor(private val repository: AuthRepository) {
    operator fun invoke() = repository.getSessionData()
}