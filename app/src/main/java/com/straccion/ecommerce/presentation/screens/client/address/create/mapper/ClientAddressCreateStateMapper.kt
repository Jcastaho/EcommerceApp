package com.straccion.ecommerce.presentation.screens.client.address.create.mapper

import com.straccion.ecommerce.domains.model.Address
import com.straccion.ecommerce.presentation.screens.client.address.create.ClientAddressCreateState

fun ClientAddressCreateState.toAddress():Address {
    return  Address(
        address = address,
        neighborhood = neighborhood,
        idUser = idUser
    )
}