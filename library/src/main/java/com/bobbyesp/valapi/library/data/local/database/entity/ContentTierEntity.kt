package com.bobbyesp.valapi.library.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "content_tiers")
data class ContentTierEntity(
    val assetPath: String = "",
    val devName: String = "",
    val displayIcon: String = "",
    val displayName: String = "",
    val highlightColor: String = "",
    val juiceCost: Int = 0,
    val juiceValue: Int = 0,
    val rank: Int = 0,
    @PrimaryKey val uuid: String = ""
)
