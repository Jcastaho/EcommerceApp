package com.straccion.ecommerce.domains.usecase.address

import com.straccion.ecommerce.domains.repository.AddressRepository

class FindByUserAddressUseCase(private val repository: AddressRepository) {
    suspend operator fun invoke(idUser: String) = repository.findByUser(idUser)
}