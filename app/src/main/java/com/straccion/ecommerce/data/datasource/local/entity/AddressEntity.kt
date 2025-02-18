package com.straccion.ecommerce.data.datasource.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "address")
data class AddressEntity(
    @PrimaryKey var id: String = "",
    @ColumnInfo(name = "address") var address: String = "",
    @ColumnInfo(name = "neighborhood") var neighborhood: String = "",
    @ColumnInfo(name = "id_user") var idUser: String = "",
)