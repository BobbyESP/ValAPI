package com.bobbyesp.valapi.library.data.local.database.entity


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bobbyesp.valapi.library.domain.model.gear.ShopData

@Entity(tableName = "gears")
data class GearEntity(
    val assetPath: String = "",
    val description: String = "",
    val displayIcon: String = "",
    val displayName: String = "",
    val shopData: ShopData = ShopData(),
    @PrimaryKey val uuid: String = ""
)