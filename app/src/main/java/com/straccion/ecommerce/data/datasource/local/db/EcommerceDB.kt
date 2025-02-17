package com.straccion.ecommerce.data.datasource.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.straccion.ecommerce.data.datasource.local.dao.CategoriesDao
import com.straccion.ecommerce.data.datasource.local.dao.ProductsDao
import com.straccion.ecommerce.data.datasource.local.dao.ShoppingBagDao
import com.straccion.ecommerce.data.datasource.local.entity.CategoryEntity
import com.straccion.ecommerce.data.datasource.local.entity.ProductEntity
import com.straccion.ecommerce.data.datasource.local.entity.ShoppingBagProductEntity

@Database(
    entities = [CategoryEntity::class, ProductEntity::class, ShoppingBagProductEntity::class],
    version = 1,
    exportSchema = false
)
abstract class EcommerceDB: RoomDatabase(){
    abstract fun categoriesDao(): CategoriesDao
    abstract fun productsDao(): ProductsDao
    abstract fun shoppingBagDao(): ShoppingBagDao


}
