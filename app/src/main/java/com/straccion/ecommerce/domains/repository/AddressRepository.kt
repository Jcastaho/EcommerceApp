package com.straccion.ecommerce.domains.repository

import com.straccion.ecommerce.domains.model.Address
import com.straccion.ecommerce.domains.util.Response
import kotlinx.coroutines.flow.Flow


interface AddressRepository {
    suspend fun create(address: Address): Response<Address>
    fun findByUser(idUser: String) : Flow<Response<List<Address>>>
}