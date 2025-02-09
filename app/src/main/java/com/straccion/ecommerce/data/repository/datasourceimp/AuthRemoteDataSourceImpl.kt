package com.straccion.ecommerce.data.repository.datasourceimp

import com.straccion.ecommerce.data.repository.datasource.AuthRemoteDataSource
import com.straccion.ecommerce.data.service.AuthService
import com.straccion.ecommerce.domains.model.AuthResponse
import com.straccion.ecommerce.domains.model.User
import retrofit2.Response

class AuthRemoteDataSourceImpl(
    private val authService: AuthService
) : AuthRemoteDataSource {

    override suspend fun login(
        email: String,
        password: String
    ) = authService.login(email, password)

    override suspend fun register(user: User): Response<AuthResponse> = authService.register(user)


}