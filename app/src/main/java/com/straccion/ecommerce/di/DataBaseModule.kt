package com.straccion.ecommerce.di

import android.app.Application
import androidx.room.Room
import com.straccion.ecommerce.data.datasource.local.dao.CategoriesDao
import com.straccion.ecommerce.data.datasource.local.dao.ProductsDao
import com.straccion.ecommerce.data.datasource.local.dao.ShoppingBagDao
import com.straccion.ecommerce.data.datasource.local.db.EcommerceDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application): EcommerceDB =
        Room.databaseBuilder(app, EcommerceDB::class.java, "ecommerce_db")
            .fallbackToDestructiveMigration().build()

    @Provides
    @Singleton // se coloca por que viene de un paquete externo
    fun provedeCategoriesDao(db: EcommerceDB): CategoriesDao = db.categoriesDao()

    @Provides
    @Singleton // se coloca por que viene de un paquete externo
    fun provedeProductsDao(db: EcommerceDB): ProductsDao = db.productsDao()

    @Provides
    @Singleton // se coloca por que viene de un paquete externo
    fun provedeShoppingBagDao(db: EcommerceDB): ShoppingBagDao = db.shoppingBagDao()
}