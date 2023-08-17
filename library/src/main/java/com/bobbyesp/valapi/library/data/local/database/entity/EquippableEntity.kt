package com.bobbyesp.valapi.library.data.local.database.entity


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "equippables")
data class EquippableEntity(
    val assetPath: String = "",
    val category: String = "",
    val displayIcon: String = "",
    val displayName: String = "",
    val killStreamIcon: String = "",
    @PrimaryKey val uuid: String = ""
)