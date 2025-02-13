package com.straccion.ecommerce.data.datasource.local.repository.datasource

import com.straccion.ecommerce.domains.model.AuthResponse
import com.straccion.ecommerce.domains.model.User
import kotlinx.coroutines.flow.Flow

interface AuthLocalDataSource {
    suspend fun saveSession(authResponse: AuthResponse)
    suspend fun updateSession(user: User)
    fun getSessionData(): Flow<AuthResponse>
    suspend fun logout()
}