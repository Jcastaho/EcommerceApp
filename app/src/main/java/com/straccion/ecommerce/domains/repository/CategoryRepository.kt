package com.straccion.ecommerce.domains.repository

import com.straccion.ecommerce.domains.model.Category
import com.straccion.ecommerce.domains.util.Response
import kotlinx.coroutines.flow.Flow
import java.io.File

interface CategoryRepository {
    suspend fun create(category: Category, file: File): Response<Category>
    fun getCategories(): Flow<Response<List<Category>>>
    suspend fun update(id: String, category: Category): Response<Category>
    suspend fun updateWithImage(id: String, category: Category, file: File): Response<Category>
    suspend fun delete(id: String): Response<Unit>
}