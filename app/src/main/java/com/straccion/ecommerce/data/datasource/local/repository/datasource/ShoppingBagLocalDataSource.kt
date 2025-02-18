package com.straccion.ecommerce.data.datasource.local.repository.datasource

import com.straccion.ecommerce.data.datasource.local.entity.ShoppingBagProductEntity
import kotlinx.coroutines.flow.Flow

interface ShoppingBagLocalDataSource {

    suspend fun insert(product: ShoppingBagProductEntity)
    suspend fun insertAll(product: List<ShoppingBagProductEntity>)
    fun findAll(): Flow<List<ShoppingBagProductEntity>>
    suspend fun findById(id: String): ShoppingBagProductEntity
    suspend fun update(
        id: String,
        quantity: Int,
    )
    suspend fun delete(id: String)
}