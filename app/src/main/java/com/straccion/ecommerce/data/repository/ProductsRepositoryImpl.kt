package com.straccion.ecommerce.data.repository

import com.straccion.ecommerce.data.datasource.local.repository.datasource.ProductsLocalDataSource
import com.straccion.ecommerce.data.datasource.remote.repository.datasource.ProductsRemoteDataSource
import com.straccion.ecommerce.data.mapper.toProduct
import com.straccion.ecommerce.data.mapper.toProductEntity
import com.straccion.ecommerce.domains.model.Product
import com.straccion.ecommerce.domains.repository.ProductsRepository
import com.straccion.ecommerce.domains.util.Response
import com.straccion.ecommerce.domains.util.ResponseToRequest
import com.straccion.ecommerce.domains.util.isListEqual
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.File


class ProductsRepositoryImpl(
    private val remoteDataSource: ProductsRemoteDataSource,
    private val localDataSource: ProductsLocalDataSource,
) : ProductsRepository {

    override fun findAll(): Flow<Response<List<Product>>> = flow {
        localDataSource.findAll().collect() {
            it.run {
                val productsLocalMap = this.map { productEntity -> productEntity.toProduct() }
                try {
                    ResponseToRequest.send(remoteDataSource.findAll()).run {
                        when (this) {
                            is Response.Success -> {
                                val productsRemote = this.data
                                if (!isListEqual(productsRemote, productsLocalMap)) {
                                    localDataSource.insertAll(productsRemote.map { product -> product.toProductEntity() })
                                }
                                emit(Response.Success(productsRemote))
                            }

                            else -> {
                                emit(Response.Success(productsLocalMap))
                            }
                        }
                    }
                } catch (e: Exception) {
                    emit(Response.Success(productsLocalMap))
                }
            }
        }
    }.flowOn(Dispatchers.IO)

    override fun findByCategory(idCategory: String): Flow<Response<List<Product>>> = flow {
        localDataSource.findByCategory(idCategory).collect() {
            it.run {
                val productsLocalMap = this.map { productEntity -> productEntity.toProduct() }
                try {
                    ResponseToRequest.send(remoteDataSource.findByCategory(idCategory)).run {
                        when (this) {
                            is Response.Success -> {
                                val productsRemote = this.data
                                if (!isListEqual(productsRemote, productsLocalMap)) {
                                    localDataSource.insertAll(productsRemote.map { product -> product.toProductEntity() })
                                }
                                emit(Response.Success(productsRemote))
                            }

                            else -> {
                                emit(Response.Success(productsLocalMap))
                            }
                        }
                    }
                } catch (e: Exception) {
                    emit(Response.Success(productsLocalMap))
                }
            }
        }
    }.flowOn(Dispatchers.IO)

    override suspend fun create(product: Product, files: List<File>): Response<Product> {
        ResponseToRequest.send(remoteDataSource.create(product, files)).run {
            return when (this) {
                is Response.Success -> {
                    localDataSource.insert(this.data.toProductEntity())
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
        product: Product,
        files: List<File?>
    ): Response<Product> {
        ResponseToRequest.send(remoteDataSource.updateWithImage(id, product, files)).run {
            return when (this) {
                is Response.Success -> {
                    localDataSource.update(
                        id = this.data.id ?: "",
                        name = this.data.name,
                        description = this.data.description,
                        image1 = this.data.image1 ?: "",
                        image2 = this.data.image2 ?: "",
                        price = this.data.price
                    )
                    Response.Success(this.data)
                }

                else -> {
                    Response.Failure("Error desconocido")
                }
            }
        }
    }

    override suspend fun update(id: String, product: Product): Response<Product> {
        ResponseToRequest.send(remoteDataSource.update(id, product)).run {
            return when (this) {
                is Response.Success -> {
                    localDataSource.update(
                        id = this.data.id ?: "",
                        name = this.data.name,
                        description = this.data.description,
                        image1 = this.data.image1 ?: "",
                        image2 = this.data.image2 ?: "",
                        price = this.data.price
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
                    localDataSource.delete(id)
                    Response.Success(Unit)
                }

                else -> {
                    Response.Failure("Error desconocido")
                }
            }
        }
    }

}