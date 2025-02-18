package com.straccion.ecommerce.domains.model

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Address(
    @SerializedName("id") val id: String? = null,
    @SerializedName("address") val address: String = "",
    @SerializedName("neighborhood") val neighborhood: String = "",
    @SerializedName("id_user") val idUser: String = ""
) : Serializable {

    fun toJson(): String = Gson().toJson(this)

    companion object {
        fun fromJson(data: String): Address = Gson().fromJson(data, Address::class.java)
    }
}
