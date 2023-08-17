package com.bobbyesp.valapi.library.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "buddy_levels")
data class BuddyLevelEntity(
    @PrimaryKey val uuid: String = "",
    val charmLevel: Int = 0,
    val displayName: String = "",
    val displayIcon: String = "",
    val assetPath: String = ""
)
