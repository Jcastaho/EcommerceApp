package com.straccion.ecommerce.di

import com.straccion.ecommerce.data.repository.datasource.AuthRemoteDataSource
import com.straccion.ecommerce.data.repository.datasource.UsersRemoteDataSource
import com.straccion.ecommerce.data.repository.datasourceimp.AuthRemoteDataSourceImpl
import com.straccion.ecommerce.data.repository.datasourceimp.UsersRemoteDataSourceImpl
import com.straccion.ecommerce.data.service.AuthService
import com.straccion.ecommerce.data.service.UsersService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataModule {
    @Provides
    fun provideAuthRemoteDataSource(authService: AuthService): AuthRemoteDataSource =
        AuthRemoteDataSourceImpl(authService)

    @Provides
    fun provideUsersRemoteDataSource(usersService: UsersService): UsersRemoteDataSource =
        UsersRemoteDataSourceImpl(usersService)
}