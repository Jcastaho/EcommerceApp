package com.straccion.ecommerce.domains.repository

import com.straccion.ecommerce.domains.model.User
import com.straccion.ecommerce.domains.util.Response
import java.io.File

interface UsersRepository {

    suspend fun update(id: String, user: User): Response<User>
    suspend fun updateWithImage(id: String, user: User, file: File): Response<User>
}