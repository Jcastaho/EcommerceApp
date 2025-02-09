package com.straccion.ecommerce.data.repository

import com.straccion.ecommerce.data.repository.datasource.UsersRemoteDataSource
import com.straccion.ecommerce.domains.model.User
import com.straccion.ecommerce.domains.repository.UsersRepository
import com.straccion.ecommerce.domains.util.Response
import com.straccion.ecommerce.domains.util.ResponseToRequest
import java.io.File


class UsersRepositoryImpl(
    private val usersRemoteDataSource: UsersRemoteDataSource,
    //  private val authLocalDataSource: AuthLocalDataSource
) : UsersRepository {

    override suspend fun update(id: String, user: User): Response<User> = ResponseToRequest.send(
        usersRemoteDataSource.update(id, user)
    )

    override suspend fun updateWithImage(id: String, user: User, file: File): Response<User> =
        ResponseToRequest.send(
            usersRemoteDataSource.updateWithImage(id, user, file)
        )


}