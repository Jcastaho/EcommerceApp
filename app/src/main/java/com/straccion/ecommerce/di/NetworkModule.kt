package com.straccion.ecommerce.di

import com.straccion.ecommerce.core.Config.BASE_URL
import com.straccion.ecommerce.data.datasource.local.datastore.AuthDataStore
import com.straccion.ecommerce.data.datasource.remote.service.AuthService
import com.straccion.ecommerce.data.datasource.remote.service.CategoriesService
import com.straccion.ecommerce.data.datasource.remote.service.ProductsService
import com.straccion.ecommerce.data.datasource.remote.service.UsersService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    //obtienemos el token para enviarlo en todas las peticiones que lo requieran
    @Provides
    @Singleton
    fun providerOkHttpClient(datastore: AuthDataStore) = OkHttpClient.Builder().addInterceptor{
        val token = runBlocking {
            datastore.getData().first().token
        }
        val newRequest = it.request().newBuilder().addHeader("Authorization", token ?: "").build()
        it.proceed(newRequest)
    }.build()

    @Provides
    @Singleton
    fun providerRetrofit(okHttpClient: OkHttpClient): Retrofit{
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideAuthService(retrofit: Retrofit): AuthService {
        return retrofit.create(AuthService::class.java)
    }

    @Provides
    @Singleton
    fun provideUsersService(retrofit: Retrofit): UsersService {
        return retrofit.create(UsersService::class.java)
    }

    @Provides
    @Singleton
    fun provideCategoriesService(retrofit: Retrofit): CategoriesService {
        return retrofit.create(CategoriesService::class.java)
    }

    @Provides
    @Singleton
    fun provideProductsService(retrofit: Retrofit): ProductsService {
        return retrofit.create(ProductsService::class.java)
    }
}