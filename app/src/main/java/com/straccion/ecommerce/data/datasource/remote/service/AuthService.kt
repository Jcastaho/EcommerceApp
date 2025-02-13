package com.straccion.ecommerce.data.datasource.remote.service

import com.straccion.ecommerce.domains.model.AuthResponse
import com.straccion.ecommerce.domains.model.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthService {
    //http://192.168.1.14:3000/auth/login
    @FormUrlEncoded
    @POST("auth/login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String,
        ): Response<AuthResponse>


    @POST("auth/register")
    suspend fun register(
        @Body() user: User,
    ): Response<AuthResponse>
}