package com.straccion.ecommerce.data.repository

import com.straccion.ecommerce.data.datasource.local.repository.datasource.AddressLocalDataSource
import com.straccion.ecommerce.data.datasource.remote.repository.datasource.AddressRemoteDataSource
import com.straccion.ecommerce.data.mapper.toAddress
import com.straccion.ecommerce.data.mapper.toEntity
import com.straccion.ecommerce.data.mapper.toProduct
import com.straccion.ecommerce.data.mapper.toProductEntity
import com.straccion.ecommerce.domains.model.Address
import com.straccion.ecommerce.domains.repository.AddressRepository
import com.straccion.ecommerce.domains.util.Response
import com.straccion.ecommerce.domains.util.ResponseToRequest
import com.straccion.ecommerce.domains.util.isListEqual
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class AddressRepositoryImpl(
    private val remoteDataSource: AddressRemoteDataSource,
    private val localDataSource: AddressLocalDataSource
) :
    AddressRepository {
    override suspend fun create(address: Address): Response<Address> {
        ResponseToRequest.send(remoteDataSource.create(address)).run {
            return when (this) {
                is Response.Success -> {
                    localDataSource.insert(this.data.toEntity())
                    Response.Success(this.data)
                }

                else -> {
                    Response.Failure("Error Desconocido")
                }
            }
        }
    }

    override fun findByUser(idUser: String): Flow<Response<List<Address>>> = flow {
        localDataSource.findByUser(idUser).collect() {
            it.run {
                val addressLocalMap = this.map { addressEntity -> addressEntity.toAddress() }
                try {
                    ResponseToRequest.send(remoteDataSource.findByUser(idUser)).run {
                        when (this) {
                            is Response.Success -> {
                                val addressRemote = this.data
                                if (!isListEqual(addressRemote, addressLocalMap)) {
                                    localDataSource.insertAll(addressRemote.map { address -> address.toEntity() })
                                }
                                emit(Response.Success(addressRemote))
                            }

                            else -> {
                                emit(Response.Success(addressLocalMap))
                            }
                        }
                    }
                } catch (e: Exception) {
                    emit(Response.Success(addressLocalMap))
                }
            }
        }
    }.flowOn(Dispatchers.IO)
}