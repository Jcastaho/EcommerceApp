package com.straccion.ecommerce.data.datasource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.straccion.ecommerce.data.datasource.local.entity.ShoppingBagProductEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ShoppingBagDao {
    //INSER INTO shopping_bag values....
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(product: ShoppingBagProductEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(product: List<ShoppingBagProductEntity>)

    @Query("SELECT * FROM shopping_bag")
    fun findAll(): Flow<List<ShoppingBagProductEntity>>

    @Query("SELECT * FROM shopping_bag WHERE id= :id")
    fun findById(id: String): ShoppingBagProductEntity

    @Query("UPDATE shopping_bag SET quantity = :quantity WHERE id = :id")
    suspend fun update(
        id: String,
        quantity: Int
    )

    @Query("DELETE FROM shopping_bag WHERE id = :id")
    suspend fun delete(id: String)
}