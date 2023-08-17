package com.bobbyesp.valapi.library.data.local.database.entity


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "seasons")
data class SeasonEntity(
    val assetPath: String = "",
    val displayName: String = "",
    val endTime: String = "",
    val parentUuid: String? = null,
    val startTime: String = "",
    val type: String? = null,
    @PrimaryKey val uuid: String = ""
)