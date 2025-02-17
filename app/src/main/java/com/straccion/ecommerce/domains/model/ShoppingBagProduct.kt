package com.straccion.ecommerce.domains.model

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

data class ShoppingBagProduct(
    @SerializedName("id") val id: String = "",
    @SerializedName("name") val name: String,
    @SerializedName("id_category") val idCategory: Int,
    @SerializedName("image1") val image1: String = "",
    @SerializedName("price") val price: Int,
    @SerializedName("quantity") val quantity: Int,
): Serializable{
    fun toJson(): String = Gson().toJson(ShoppingBagProduct(
        id,
        name,
        idCategory,
        if (!image1.isNullOrBlank()) URLEncoder.encode(image1, StandardCharsets.UTF_8.toString()) else "",
        price,
        quantity
    ))
    companion object{
        fun fromJson(data: String): ShoppingBagProduct = Gson().fromJson(data, ShoppingBagProduct::class.java)
    }
}