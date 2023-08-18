package com.bobbyesp.valapi.library.data.local.database.entity


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "player_titles")
data class PlayerTitleEntity(
    val assetPath: String = "",
    val displayName: String? = null,
    val isHiddenIfNotOwned: Boolean = false,
    val titleText: String? = null,
    @PrimaryKey val uuid: String = "",
    val timestamp: Long = System.currentTimeMillis()
)