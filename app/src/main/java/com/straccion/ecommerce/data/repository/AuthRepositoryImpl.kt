package com.straccion.ecommerce.data.repository

import com.straccion.ecommerce.data.datasource.local.repository.datasource.AuthLocalDataSource
import com.straccion.ecommerce.data.datasource.remote.repository.datasource.AuthRemoteDataSource
import com.straccion.ecommerce.domains.model.AuthResponse
import com.straccion.ecommerce.domains.model.User
import com.straccion.ecommerce.domains.repository.AuthRepository
import com.straccion.ecommerce.domains.util.Response
import com.straccion.ecommerce.domains.util.ResponseToRequest
import kotlinx.coroutines.flow.Flow


class AuthRepositoryImpl(
    private val authRemoteDataSource: AuthRemoteDataSource,
    private val authLocalDataSource: AuthLocalDataSource
): AuthRepository {
    override suspend fun login(email: String, password: String): Response<AuthResponse> = ResponseToRequest.send(
        authRemoteDataSource.login(email, password)
    )

    override suspend fun register(user: User): Response<AuthResponse> = ResponseToRequest.send(
        authRemoteDataSource.register(user)
    )

    override suspend fun updateSession(user: User) = authLocalDataSource.updateSession(user)

    override suspend fun saveSession(authResponse: AuthResponse) = authLocalDataSource.saveSession(authResponse)

    override fun getSessionData(): Flow<AuthResponse> = authLocalDataSource.getSessionData()

    override suspend fun logout() = authLocalDataSource.logout()

}