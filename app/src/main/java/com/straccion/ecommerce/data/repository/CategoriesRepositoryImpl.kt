package com.straccion.ecommerce.data.repository

import com.straccion.ecommerce.data.repository.datasource.CategoriesRemoteDataSource
import com.straccion.ecommerce.domains.model.Category
import com.straccion.ecommerce.domains.repository.CategoryRepository
import com.straccion.ecommerce.domains.util.Response
import com.straccion.ecommerce.domains.util.ResponseToRequest
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import java.io.File


class CategoriesRepositoryImpl(
    private val categoriesRemoteDataSource: CategoriesRemoteDataSource
): CategoryRepository {

    override suspend fun create(category: Category, file: File): Response<Category> = ResponseToRequest.send(
        categoriesRemoteDataSource.create(category, file)
    )

    override fun getCategories(): Flow<Response<List<Category>>> = callbackFlow {
        trySend(ResponseToRequest.send(categoriesRemoteDataSource.getCategories()))
        awaitClose{
            cancel()
        }
    }

    override suspend fun update(id: String, category: Category): Response<Category> = ResponseToRequest.send(
        categoriesRemoteDataSource.update(id, category)
    )


    override suspend fun updateWithImage(
        id: String,
        category: Category,
        file: File
    ): Response<Category> = ResponseToRequest.send(
        categoriesRemoteDataSource.updateWithImage(id, category, file)
    )

    override suspend fun delete(id: String): Response<Unit> {
        TODO("Not yet implemented")
    }


}