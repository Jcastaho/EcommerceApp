package com.straccion.ecommerce.data.datasource.local.repository.datasource

import com.straccion.ecommerce.data.datasource.local.entity.ProductEntity
import kotlinx.coroutines.flow.Flow

interface ProductsLocalDataSource {

    suspend fun insert(product: ProductEntity)
    suspend fun insertAll(product: List<ProductEntity>)
    fun findAll(): Flow<List<ProductEntity>>
    fun findByCategory(idCategory: String): Flow<List<ProductEntity>>
    suspend fun update(
        id: String,
        name: String,
        description: String,
        image1: String,
        image2: String,
        price: Int
    )
    suspend fun delete(id: String)
}