package com.bobbyesp.valapi.library.data.local.database.entity


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "events")
data class EventEntity(
    val assetPath: String = "",
    val displayName: String = "",
    val endTime: String = "",
    val shortDisplayName: String = "",
    val startTime: String = "",
    @PrimaryKey val uuid: String = ""
)