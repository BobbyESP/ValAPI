package com.bobbyesp.valapi.library.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ceremonies")
data class CeremonyEntity(
    val assetPath: String = "",
    val displayName: String = "",
    @PrimaryKey val uuid: String = "",
    val timestamp: Long = System.currentTimeMillis()
)
