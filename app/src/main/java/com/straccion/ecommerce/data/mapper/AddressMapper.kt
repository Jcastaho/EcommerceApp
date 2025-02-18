package com.straccion.ecommerce.data.mapper

import com.straccion.ecommerce.data.datasource.local.entity.AddressEntity
import com.straccion.ecommerce.domains.model.Address

fun AddressEntity.toAddress(): Address {
    return Address(
        id = id,
        address = address,
        neighborhood = neighborhood,
        idUser = idUser
    )
}

fun Address.toEntity(): AddressEntity {
    return AddressEntity(
        id = id ?: "",
        address = address,
        neighborhood = neighborhood,
        idUser = idUser
    )
}