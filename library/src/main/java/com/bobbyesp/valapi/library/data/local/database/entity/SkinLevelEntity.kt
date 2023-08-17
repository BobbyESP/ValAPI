package com.bobbyesp.valapi.library.data.local.database.entity


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weapon_skins_levels")
data class SkinLevelEntity(
    val assetPath: String = "",
    val displayIcon: String? = null,
    val displayName: String = "",
    val levelItem: String? = null,
    val streamedVideo: String? = null,
    @PrimaryKey val uuid: String = ""
)