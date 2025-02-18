package com.straccion.ecommerce.domains.usecase.address

import com.straccion.ecommerce.domains.model.Address
import com.straccion.ecommerce.domains.repository.AddressRepository

class CreateAddressUseCase(private val repository: AddressRepository) {
    suspend operator fun invoke(address: Address) = repository.create(address)
}