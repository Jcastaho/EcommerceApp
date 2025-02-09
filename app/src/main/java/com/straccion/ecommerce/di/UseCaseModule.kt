package com.straccion.ecommerce.di


import com.straccion.ecommerce.domains.repository.AuthRepository
import com.straccion.ecommerce.domains.repository.UsersRepository
import com.straccion.ecommerce.domains.usecase.auth.AuthUseCase
import com.straccion.ecommerce.domains.usecase.auth.GetSessionDataUseCase
import com.straccion.ecommerce.domains.usecase.auth.LoginUseCase
import com.straccion.ecommerce.domains.usecase.auth.LogoutUseCase
import com.straccion.ecommerce.domains.usecase.auth.RegisterUseCase
import com.straccion.ecommerce.domains.usecase.auth.SaveSessionUseCase
import com.straccion.ecommerce.domains.usecase.auth.UpdateSessionUseCase
import com.straccion.ecommerce.domains.usecase.users.UpdateUserUseCase
import com.straccion.ecommerce.domains.usecase.users.UpdateUserWithImageUseCase
import com.straccion.ecommerce.domains.usecase.users.UsersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideAuthUseCase(authRepository: AuthRepository) =
        AuthUseCase(
            login = LoginUseCase(authRepository),
            register = RegisterUseCase(authRepository),
            saveSessionUseCase = SaveSessionUseCase(authRepository),
            getSessionDataUseCase = GetSessionDataUseCase(authRepository),
            logoutUseCase = LogoutUseCase(authRepository),
            updateSessionUseCase = UpdateSessionUseCase(authRepository)
        )

    @Provides
    fun provideUserUseCase(usersRepository: UsersRepository) =
        UsersUseCase(
            updateUserUseCase = UpdateUserUseCase(usersRepository),
            updateUserWithImage = UpdateUserWithImageUseCase(usersRepository)
        )
}