package com.bobbyesp.valapi.library.data.local.database.entity


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "spray_levels")
data class SprayLevelEntity(
    val assetPath: String = "",
    val displayIcon: String? = null,
    val displayName: String = "",
    val sprayLevel: Int = 0,
    @PrimaryKey val uuid: String = ""
)