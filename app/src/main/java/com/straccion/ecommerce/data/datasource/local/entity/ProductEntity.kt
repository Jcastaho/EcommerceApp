package com.straccion.ecommerce.data.datasource.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "products")
data class ProductEntity(
    @PrimaryKey var id: String = "",
    @ColumnInfo("name") var name: String = "",
    @ColumnInfo("description") var description: String = "",
    @ColumnInfo("id_category") var idCategory: Int = 0,
    @ColumnInfo("image1") var image1: String = "",
    @ColumnInfo("image2") var image2: String = "",
    @ColumnInfo("price") var price: Int = 0
)