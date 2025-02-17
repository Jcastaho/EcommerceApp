package com.straccion.ecommerce.data.datasource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.straccion.ecommerce.data.datasource.local.entity.ProductEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductsDao {
    //INSER INTO categories values....
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(product: ProductEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(product: List<ProductEntity>)

    @Query("SELECT * FROM products")
    fun findAll(): Flow<List<ProductEntity>>

    @Query("SELECT * FROM products WHERE id_category = :id_category")
    fun findByCategory(id_category: String): Flow<List<ProductEntity>>

    @Query("UPDATE products SET name = :name, description = :description, image1 = :image1, image2 = :image2, price = :price WHERE id = :id")
    suspend fun update(
        id: String,
        name: String,
        description: String,
        image1: String,
        image2: String,
        price: Int
    )

    @Query("DELETE FROM products WHERE id = :id")
    suspend fun delete(id: String)
}