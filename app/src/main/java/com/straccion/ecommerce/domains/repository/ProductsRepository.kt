package com.straccion.ecommerce.domains.repository

import com.straccion.ecommerce.domains.model.Product
import com.straccion.ecommerce.domains.util.Response
import kotlinx.coroutines.flow.Flow
import java.io.File

interface ProductsRepository {
    fun findAll(): Flow<Response<List<Product>>>
    fun findByCategory(idCategory: String): Flow<Response<List<Product>>>
    suspend fun create(product: Product, files: List<File>): Response<Product>
    suspend fun updateWithImage(id: String, product: Product, files: List<File?>): Response<Product>
    suspend fun update(id: String, product: Product): Response<Product>
    suspend fun delete(id: String): Response<Unit>

}