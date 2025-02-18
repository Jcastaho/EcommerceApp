package com.straccion.ecommerce.di

import com.straccion.ecommerce.data.datasource.local.dao.AddressDao
import com.straccion.ecommerce.data.datasource.local.dao.CategoriesDao
import com.straccion.ecommerce.data.datasource.local.dao.ProductsDao
import com.straccion.ecommerce.data.datasource.local.dao.ShoppingBagDao
import com.straccion.ecommerce.data.datasource.local.datastore.AuthDataStore
import com.straccion.ecommerce.data.datasource.local.repository.datasource.AddressLocalDataSource
import com.straccion.ecommerce.data.datasource.local.repository.datasource.AuthLocalDataSource
import com.straccion.ecommerce.data.datasource.local.repository.datasource.CategoriesLocalDataSource
import com.straccion.ecommerce.data.datasource.local.repository.datasource.ProductsLocalDataSource
import com.straccion.ecommerce.data.datasource.local.repository.datasource.ShoppingBagLocalDataSource
import com.straccion.ecommerce.data.datasource.local.repository.datasourceimp.AddressLocalDataSourceImpl
import com.straccion.ecommerce.data.datasource.local.repository.datasourceimp.AuthLocalDataSourceImpl
import com.straccion.ecommerce.data.datasource.local.repository.datasourceimp.CategoriesLocalDataSourceImpl
import com.straccion.ecommerce.data.datasource.local.repository.datasourceimp.ProductsLocalDataSourceImpl
import com.straccion.ecommerce.data.datasource.local.repository.datasourceimp.ShoppingBagLocalDataSourceImpl
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
    fun provideCategoriesLocalDataSource(categoriesDao: CategoriesDao): CategoriesLocalDataSource =
        CategoriesLocalDataSourceImpl(categoriesDao)

    @Provides
    fun provideProductsLocalDataSource(productsDao: ProductsDao): ProductsLocalDataSource =
        ProductsLocalDataSourceImpl(productsDao)

    @Provides
    fun provideShoppingBagLocalDataSource(shoppingBagDao: ShoppingBagDao): ShoppingBagLocalDataSource =
        ShoppingBagLocalDataSourceImpl(shoppingBagDao)

    @Provides
    fun provideAddressLocalDataSource(addressDao: AddressDao): AddressLocalDataSource =
        AddressLocalDataSourceImpl(addressDao)

}