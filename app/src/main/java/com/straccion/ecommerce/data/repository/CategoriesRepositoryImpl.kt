package com.straccion.ecommerce.data.repository

import android.util.Log
import com.straccion.ecommerce.data.datasource.local.entity.CategoryEntity
import com.straccion.ecommerce.data.datasource.local.repository.datasource.CategoriesLocalDataSource
import com.straccion.ecommerce.data.datasource.remote.repository.datasource.CategoriesRemoteDataSource
import com.straccion.ecommerce.data.mapper.toCategory
import com.straccion.ecommerce.data.mapper.toCategoryEntity
import com.straccion.ecommerce.domains.model.Category
import com.straccion.ecommerce.domains.repository.CategoryRepository
import com.straccion.ecommerce.domains.util.Response
import com.straccion.ecommerce.domains.util.ResponseToRequest
import com.straccion.ecommerce.domains.util.isListEqual
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.File


class CategoriesRepositoryImpl(
    private val remoteDataSource: CategoriesRemoteDataSource,
    private val localDataSource: CategoriesLocalDataSource
) : CategoryRepository {

    override suspend fun create(category: Category, file: File): Response<Category> {
        ResponseToRequest.send(remoteDataSource.create(category, file)).run {
            return when (this) {
                is Response.Success -> {
                    localDataSource.create(this.data.toCategoryEntity())
                    Response.Success(this.data)
                }

                else -> {
                    Response.Failure("Error desconocido")
                }
            }
        }
    }

    override fun getCategories(): Flow<Response<List<Category>>> = flow {
        localDataSource.getCategories().collect() {
            it.run {
                val categoriesLocalMap =
                    this.map { categoryEntity -> categoryEntity.toCategory() }
                try {
                    ResponseToRequest.send(remoteDataSource.getCategories()).run {
                        when (this) {
                            is Response.Success -> {
                                val categoriesRemote = this.data
                                if (!isListEqual(categoriesRemote, categoriesLocalMap)) {
                                    localDataSource.insertAll(categoriesRemote.map { category -> category.toCategoryEntity() })
                                }

                                emit(Response.Success(categoriesRemote))
                            }

                            is Response.Failure -> {
                                emit(Response.Success(categoriesLocalMap))
                            }

                            else -> {
                                emit(Response.Success(categoriesLocalMap))
                            }
                        }
                    }
                } catch (e: Exception) {
                    emit(Response.Success(categoriesLocalMap))

                }
            }
        }
    }.flowOn(Dispatchers.IO)

    override suspend fun update(id: String, category: Category): Response<Category> {
        ResponseToRequest.send(remoteDataSource.update(id, category)).run {
            return when (this) {
                is Response.Success -> {
                    localDataSource.update(
                        id = this.data.id ?: "",
                        name = this.data.name,
                        description = this.data.description,
                        image = this.data.image ?: ""
                    )
                    Response.Success(this.data)
                }

                else -> {
                    Response.Failure("Error desconocido")
                }
            }
        }
    }


    override suspend fun updateWithImage(
        id: String,
        category: Category,
        file: File
    ): Response<Category> {
        ResponseToRequest.send(remoteDataSource.updateWithImage(id, category, file)).run {
            return when (this) {
                is Response.Success -> {
                    localDataSource.update(
                        id = this.data.id ?: "",
                        name = this.data.name,
                        description = this.data.description,
                        image = this.data.image ?: ""
                    )
                    Response.Success(this.data)
                }

                else -> {
                    Response.Failure("Error desconocido")
                }
            }
        }
    }

    override suspend fun delete(id: String): Response<Unit> {
        ResponseToRequest.send(remoteDataSource.delete(id)).run {
            return when (this) {
                is Response.Success -> {
                    try {
                        localDataSource.delete(id)
                        Response.Success(Unit)
                    } catch (e: Exception) {
                        Response.Failure("Error al eliminar en la base de datos local: ${e.message}")
                    }
                }
                else -> {
                    Response.Failure("Error desconocido2222")
                }
            }
        }
    }
}