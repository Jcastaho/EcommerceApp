package com.straccion.ecommerce.data.datasource.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "shopping_bag")
data class ShoppingBagProductEntity(
    @PrimaryKey var id: String = "",
    @ColumnInfo("name") var name: String = "",
    @ColumnInfo("id_category") var idCategory: Int = 0,
    @ColumnInfo("image1") var image1: String = "",
    @ColumnInfo("price") var price: Int = 0,
    @ColumnInfo("quantity") var quantity: Int = 0

)