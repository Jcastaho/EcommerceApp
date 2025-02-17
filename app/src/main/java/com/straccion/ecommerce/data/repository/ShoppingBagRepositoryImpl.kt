package com.straccion.ecommerce.data.repository

import android.util.Log
import com.straccion.ecommerce.data.datasource.local.repository.datasource.ShoppingBagLocalDataSource
import com.straccion.ecommerce.data.mapper.toEntity
import com.straccion.ecommerce.data.mapper.toShoppingBagProduct
import com.straccion.ecommerce.domains.model.ShoppingBagProduct
import com.straccion.ecommerce.domains.repository.ShoppingBagRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class ShoppingBagRepositoryImpl(
    private val localDataSource: ShoppingBagLocalDataSource
) : ShoppingBagRepository {
    override suspend fun add(product: ShoppingBagProduct) {
        CoroutineScope(Dispatchers.IO).launch {
            val shoppingBag = localDataSource.findById(product.id)
            if (shoppingBag == null) {
                Log.d("ShoppingBagRepositoryImpl", "Creando datos")
                localDataSource.insert(product.toEntity())
            } else {
                Log.d("ShoppingBagRepositoryImpl", "Ya estaba creado")
                localDataSource.update(product.id, product.quantity)
            }
        }
    }

    override suspend fun delete(id: String) {
        localDataSource.delete(id)
    }

    override fun findAll(): Flow<List<ShoppingBagProduct>> = flow {
        localDataSource.findAll().collect() {
            emit(it.map { entity -> entity.toShoppingBagProduct() })
        }
    }


}