package com.straccion.ecommerce.data.datasource.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.straccion.ecommerce.data.datasource.local.dao.CategoriesDao
import com.straccion.ecommerce.data.datasource.local.entity.CategoryEntity

@Database(
    entities = [CategoryEntity::class],
    version = 1,
    exportSchema = false
)
abstract class EcommerceDB: RoomDatabase(){
    abstract fun categoriesDao(): CategoriesDao


}
