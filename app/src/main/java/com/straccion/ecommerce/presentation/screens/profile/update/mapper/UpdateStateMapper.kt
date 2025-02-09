package com.straccion.ecommerce.presentation.screens.profile.update.mapper

import com.straccion.ecommerce.domains.model.User
import com.straccion.ecommerce.presentation.screens.profile.update.ProfileUpdateState

fun ProfileUpdateState.toUser():User {
    return User(
        name = name,
        lastname = lastname,
        phone = phone,
        image = image
    )
}