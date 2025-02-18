package com.straccion.ecommerce.domains.usecase.address

data class AddressUseCase(
    val createAddressUseCase: CreateAddressUseCase,
    val findByUserAddressUseCase: FindByUserAddressUseCase
)
