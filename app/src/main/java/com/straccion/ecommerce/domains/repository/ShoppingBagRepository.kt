package com.straccion.ecommerce.domains.repository

import com.straccion.ecommerce.domains.model.ShoppingBagProduct
import kotlinx.coroutines.flow.Flow

interface ShoppingBagRepository {
    suspend fun add(product: ShoppingBagProduct)
    suspend fun delete(id: String)
    fun findAll(): Flow<List<ShoppingBagProduct>>
}