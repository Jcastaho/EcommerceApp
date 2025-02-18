package com.straccion.ecommerce.data.datasource.remote.repository.datasourceimp

import com.straccion.ecommerce.data.datasource.remote.repository.datasource.AddressRemoteDataSource
import com.straccion.ecommerce.data.datasource.remote.service.AddressService
import com.straccion.ecommerce.domains.model.Address
import retrofit2.Response

class AddressRemoteDataSourceImpl(private val addressService: AddressService): AddressRemoteDataSource {
    override suspend fun create(address: Address): Response<Address> = addressService.create(address)

    override suspend fun findByUser(idUser: String): Response<List<Address>> = addressService.findByUser(idUser)
}