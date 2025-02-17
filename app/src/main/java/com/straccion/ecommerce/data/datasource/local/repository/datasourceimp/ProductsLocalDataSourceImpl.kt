package com.straccion.ecommerce.data.datasource.local.repository.datasourceimp

import com.straccion.ecommerce.data.datasource.local.dao.ProductsDao
import com.straccion.ecommerce.data.datasource.local.entity.ProductEntity
import com.straccion.ecommerce.data.datasource.local.repository.datasource.ProductsLocalDataSource
import kotlinx.coroutines.flow.Flow

class ProductsLocalDataSourceImpl(
    private val productsDao: ProductsDao
) : ProductsLocalDataSource {

    override suspend fun insert(product: ProductEntity) = productsDao.insert(product)

    override suspend fun insertAll(product: List<ProductEntity>) = productsDao.insertAll(product)

    override fun findAll(): Flow<List<ProductEntity>> = productsDao.findAll()
    override fun findByCategory(idCategory: String): Flow<List<ProductEntity>> = productsDao.findByCategory(idCategory)

    override suspend fun update(
        id: String,
        name: String,
        description: String,
        image1: String,
        image2: String,
        price: Int
    ) = productsDao.update(id, name, description, image1, image2, price)

    override suspend fun delete(id: String) = productsDao.delete(id)
}