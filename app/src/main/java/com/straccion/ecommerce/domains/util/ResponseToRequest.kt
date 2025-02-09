package com.straccion.ecommerce.domains.util

import com.straccion.ecommerce.domains.model.ErrorResponse
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

object ResponseToRequest {
    fun <T> send(result: Response<T>): com.straccion.ecommerce.domains.util.Response<T>{
        return try {
            if (result.isSuccessful){//201
                com.straccion.ecommerce.domains.util.Response.Success(result.body()!!)
            }else{
                val errorResponse: ErrorResponse? = ConvertErrorBody.convert(result.errorBody())
                com.straccion.ecommerce.domains.util.Response.Failure(errorResponse?.message ?: "Error desconocido")
            }

        }
        catch (e: HttpException){
            e.printStackTrace()
            com.straccion.ecommerce.domains.util.Response.Failure(e.message ?: "Error desconocido en la peticion http")
        }
        catch (e: IOException){
            e.printStackTrace()
            com.straccion.ecommerce.domains.util.Response.Failure("Verifica tu conexion a internet")
        }
        catch (e: Exception){
            e.printStackTrace()
            com.straccion.ecommerce.domains.util.Response.Failure(e.message ?: "Error desconocido")
        }
    }
}