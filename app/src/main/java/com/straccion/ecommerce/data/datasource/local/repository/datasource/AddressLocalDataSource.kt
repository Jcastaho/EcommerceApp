package com.straccion.ecommerce.data.datasource.local.repository.datasource

import com.straccion.ecommerce.data.datasource.local.entity.AddressEntity
import kotlinx.coroutines.flow.Flow

interface AddressLocalDataSource {

    suspend fun insert(address: AddressEntity)
    suspend fun insertAll(address: List<AddressEntity>)
    fun findByUser(idUser: String ): Flow<List<AddressEntity>>
    suspend fun update(id: String, address: String, neighborhood: String)
    suspend fun delete(id: String)
}