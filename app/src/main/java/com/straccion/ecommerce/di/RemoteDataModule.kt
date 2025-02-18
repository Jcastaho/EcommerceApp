package com.straccion.ecommerce.di

import com.straccion.ecommerce.data.datasource.remote.repository.datasource.AddressRemoteDataSource
import com.straccion.ecommerce.data.datasource.remote.repository.datasource.AuthRemoteDataSource
import com.straccion.ecommerce.data.datasource.remote.repository.datasource.CategoriesRemoteDataSource
import com.straccion.ecommerce.data.datasource.remote.repository.datasource.ProductsRemoteDataSource
import com.straccion.ecommerce.data.datasource.remote.repository.datasource.UsersRemoteDataSource
import com.straccion.ecommerce.data.datasource.remote.repository.datasourceimp.AddressRemoteDataSourceImpl
import com.straccion.ecommerce.data.datasource.remote.repository.datasourceimp.AuthRemoteDataSourceImpl
import com.straccion.ecommerce.data.datasource.remote.repository.datasourceimp.CategoriesRemoteDataSourceImpl
import com.straccion.ecommerce.data.datasource.remote.repository.datasourceimp.ProductsRemoteDataSourceImpl
import com.straccion.ecommerce.data.datasource.remote.repository.datasourceimp.UsersRemoteDataSourceImpl
import com.straccion.ecommerce.data.datasource.remote.service.AddressService
import com.straccion.ecommerce.data.datasource.remote.service.AuthService
import com.straccion.ecommerce.data.datasource.remote.service.CategoriesService
import com.straccion.ecommerce.data.datasource.remote.service.ProductsService
import com.straccion.ecommerce.data.datasource.remote.service.UsersService
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

    @Provides
    fun provideCategoriesRemoteDataSource(categoriesService: CategoriesService): CategoriesRemoteDataSource =
        CategoriesRemoteDataSourceImpl(categoriesService)

    @Provides
    fun provideProductsRemoteDataSource(productsService: ProductsService): ProductsRemoteDataSource =
        ProductsRemoteDataSourceImpl(productsService)

    @Provides
    fun provideAddressRemoteDataSource(addressService: AddressService): AddressRemoteDataSource =
        AddressRemoteDataSourceImpl(addressService)
}