package com.straccion.ecommerce.presentation.screens.auth.register.mapper

import com.straccion.ecommerce.domains.model.User
import com.straccion.ecommerce.presentation.screens.auth.register.RegisterState

fun RegisterState.toUser():User {
    return User(
        name = name,
        lastname = lastname,
        email = email,
        phone = phone,
        password = password
    )
}