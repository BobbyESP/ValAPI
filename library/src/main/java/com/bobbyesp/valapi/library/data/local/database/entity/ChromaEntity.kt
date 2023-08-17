package com.bobbyesp.valapi.library.data.local.database.entity


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weapon_skins_chromas")
data class ChromaEntity(
    val assetPath: String = "",
    val displayIcon: String? = null,
    val displayName: String = "",
    val fullRender: String = "",
    val streamedVideo: String? = null,
    val swatch: String? = null,
    @PrimaryKey val uuid: String = ""
)