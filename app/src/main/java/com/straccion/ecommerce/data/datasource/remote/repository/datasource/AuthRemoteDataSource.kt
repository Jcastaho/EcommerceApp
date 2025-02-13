package com.straccion.ecommerce.data.datasource.remote.repository.datasource

import com.straccion.ecommerce.domains.model.AuthResponse
import com.straccion.ecommerce.domains.model.User
import retrofit2.Response

interface AuthRemoteDataSource {
    suspend fun login(email: String, password: String): Response<AuthResponse>
    suspend fun register(user: User): Response<AuthResponse>
}