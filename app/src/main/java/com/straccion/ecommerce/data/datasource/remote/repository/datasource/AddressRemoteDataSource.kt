package com.straccion.ecommerce.data.datasource.remote.repository.datasource

import com.straccion.ecommerce.domains.model.Address
import retrofit2.Response

interface AddressRemoteDataSource {

    suspend fun create(address: Address): Response<Address>
    suspend fun findByUser(idUser: String): Response<List<Address>>
}