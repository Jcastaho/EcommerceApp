package com.straccion.ecommerce.domains.usecase.auth

data class AuthUseCase(
    val login: LoginUseCase,
    val register: RegisterUseCase,
    val saveSessionUseCase: SaveSessionUseCase,
    val getSessionDataUseCase: GetSessionDataUseCase,
    val logoutUseCase: LogoutUseCase,
    val updateSessionUseCase: UpdateSessionUseCase
)
