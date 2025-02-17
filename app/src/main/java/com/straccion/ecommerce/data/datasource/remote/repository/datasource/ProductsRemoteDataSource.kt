package com.straccion.ecommerce.data.datasource.remote.repository.datasource

import com.straccion.ecommerce.domains.model.Product
import retrofit2.Response
import java.io.File

interface ProductsRemoteDataSource {

    suspend fun findAll(): Response<List<Product>>
    suspend fun findByCategory(idCategory: String): Response<List<Product>>
    suspend fun create(product: Product, files: List<File>): Response<Product>
    suspend fun updateWithImage(id: String, product: Product, files: List<File?>): Response<Product>
    suspend fun update(id: String, product: Product): Response<Product>
    suspend fun delete(id: String): Response<Unit>
}