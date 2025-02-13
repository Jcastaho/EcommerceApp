package com.straccion.ecommerce.di

import com.straccion.ecommerce.data.repository.AuthRepositoryImpl
import com.straccion.ecommerce.data.repository.CategoriesRepositoryImpl
import com.straccion.ecommerce.data.repository.UsersRepositoryImpl
import com.straccion.ecommerce.data.datasource.local.repository.datasource.AuthLocalDataSource
import com.straccion.ecommerce.data.datasource.local.repository.datasource.CategoriesLocalDataSource
import com.straccion.ecommerce.data.datasource.remote.repository.datasource.AuthRemoteDataSource
import com.straccion.ecommerce.data.datasource.remote.repository.datasource.CategoriesRemoteDataSource
import com.straccion.ecommerce.data.datasource.remote.repository.datasource.UsersRemoteDataSource
import com.straccion.ecommerce.domains.repository.AuthRepository
import com.straccion.ecommerce.domains.repository.CategoryRepository
import com.straccion.ecommerce.domains.repository.UsersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideAuthRepository(
        authRemoteDataSource: AuthRemoteDataSource,
        authLocalDataSource: AuthLocalDataSource
    ): AuthRepository =
        AuthRepositoryImpl(authRemoteDataSource, authLocalDataSource)

    @Provides
    fun provideUserRepository(
        usersRemoteDataSource: UsersRemoteDataSource
    ): UsersRepository =
        UsersRepositoryImpl(usersRemoteDataSource)

    @Provides
    fun provideCategoryRepository(
        remoteDataSource: CategoriesRemoteDataSource,
        localDataSource: CategoriesLocalDataSource
    ): CategoryRepository =
        CategoriesRepositoryImpl(remoteDataSource, localDataSource)
}