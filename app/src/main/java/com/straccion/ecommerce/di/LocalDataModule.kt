package com.straccion.ecommerce.di

import com.straccion.ecommerce.data.datastore.AuthDataStore
import com.straccion.ecommerce.data.repository.datasource.AuthLocalDataSource
import com.straccion.ecommerce.data.repository.datasource.AuthRemoteDataSource
import com.straccion.ecommerce.data.repository.datasourceimp.AuthLocalDataSourceImpl
import com.straccion.ecommerce.data.repository.datasourceimp.AuthRemoteDataSourceImpl
import com.straccion.ecommerce.data.service.AuthService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object LocalDataModule {
    @Provides
    fun provideAuthLocalDataSource(authDataStore: AuthDataStore): AuthLocalDataSource =
        AuthLocalDataSourceImpl(authDataStore)
}