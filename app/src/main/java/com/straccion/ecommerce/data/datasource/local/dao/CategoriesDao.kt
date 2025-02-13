package com.straccion.ecommerce.data.datasource.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.straccion.ecommerce.data.datasource.local.entity.CategoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoriesDao {
    //INSER INTO categories values....
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(category: CategoryEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(categories: List<CategoryEntity>)

    @Query("SELECT * FROM categories")
    fun getCategories(): Flow<List<CategoryEntity>>

    @Query("UPDATE categories SET name = :name, description = :description, image= :image WHERE id = :id")
    suspend fun update(id: String, name: String, description: String, image: String)

    @Query("DELETE FROM categories WHERE id = :id")
    suspend fun delete(id: String)
}