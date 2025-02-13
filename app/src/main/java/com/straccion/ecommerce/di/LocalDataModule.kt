package com.straccion.ecommerce.di

import com.straccion.ecommerce.data.datasource.local.dao.CategoriesDao
import com.straccion.ecommerce.data.datasource.local.datastore.AuthDataStore
import com.straccion.ecommerce.data.datasource.local.repository.datasource.AuthLocalDataSource
import com.straccion.ecommerce.data.datasource.local.repository.datasource.CategoriesLocalDataSource
import com.straccion.ecommerce.data.datasource.local.repository.datasourceimp.AuthLocalDataSourceImpl
import com.straccion.ecommerce.data.datasource.local.repository.datasourceimp.CategoriesLocalDataSourceImpl
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

    @Provides
    fun provideCategoriesLocalDataSource(categoriesDao: CategoriesDao): CategoriesLocalDataSource = CategoriesLocalDataSourceImpl(categoriesDao)
}