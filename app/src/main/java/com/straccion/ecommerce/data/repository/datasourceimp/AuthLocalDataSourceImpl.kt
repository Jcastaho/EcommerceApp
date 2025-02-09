package com.straccion.ecommerce.data.repository.datasourceimp

import com.straccion.ecommerce.data.datastore.AuthDataStore
import com.straccion.ecommerce.data.repository.datasource.AuthLocalDataSource
import com.straccion.ecommerce.domains.model.AuthResponse
import com.straccion.ecommerce.domains.model.User
import kotlinx.coroutines.flow.Flow

class AuthLocalDataSourceImpl constructor(private val authDataStore: AuthDataStore) :
    AuthLocalDataSource {

    override suspend fun saveSession(authResponse: AuthResponse) = authDataStore.save(authResponse)
    override suspend fun updateSession(user: User) = authDataStore.update(user)

    override fun getSessionData(): Flow<AuthResponse> = authDataStore.getData()

    override suspend fun logout() = authDataStore.delete()
}