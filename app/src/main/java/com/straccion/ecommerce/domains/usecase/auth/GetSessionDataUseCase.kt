package com.straccion.ecommerce.domains.usecase.auth

import com.straccion.ecommerce.domains.repository.AuthRepository

class GetSessionDataUseCase (private val repository: AuthRepository) {
    operator fun invoke() = repository.getSessionData()
}