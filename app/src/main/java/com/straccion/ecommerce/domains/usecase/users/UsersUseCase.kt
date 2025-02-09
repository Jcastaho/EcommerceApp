package com.straccion.ecommerce.domains.usecase.users

data class UsersUseCase(
    val updateUserUseCase: UpdateUserUseCase,
    val updateUserWithImage: UpdateUserWithImageUseCase
)
