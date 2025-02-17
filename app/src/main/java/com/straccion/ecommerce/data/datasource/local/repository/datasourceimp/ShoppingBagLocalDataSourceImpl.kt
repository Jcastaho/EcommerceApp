package com.straccion.ecommerce.data.datasource.local.repository.datasourceimp

import com.straccion.ecommerce.data.datasource.local.dao.ShoppingBagDao
import com.straccion.ecommerce.data.datasource.local.entity.ShoppingBagProductEntity
import com.straccion.ecommerce.data.datasource.local.repository.datasource.ShoppingBagLocalDataSource
import kotlinx.coroutines.flow.Flow

class ShoppingBagLocalDataSourceImpl(
    private val shoppingBagDao: ShoppingBagDao
) : ShoppingBagLocalDataSource {
    override suspend fun insert(product: ShoppingBagProductEntity) = shoppingBagDao.insert(product)

    override suspend fun insertAll(product: List<ShoppingBagProductEntity>) =
        shoppingBagDao.insertAll(product)

    override fun findAll(): Flow<List<ShoppingBagProductEntity>> = shoppingBagDao.findAll()

    override fun findById(id: String): ShoppingBagProductEntity = shoppingBagDao.findById(id)

    override suspend fun update(id: String, quantity: Int) = shoppingBagDao.update(id, quantity)

    override suspend fun delete(id: String) = shoppingBagDao.delete(id)

}