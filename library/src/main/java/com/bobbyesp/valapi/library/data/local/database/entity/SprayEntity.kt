package com.bobbyesp.valapi.library.data.local.database.entity


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sprays")
data class SprayEntity(
    val animationGif: String? = null,
    val animationPng: String? = null,
    val assetPath: String = "",
    val category: String? = null,
    val displayIcon: String = "",
    val displayName: String = "",
    val fullIcon: String? = null,
    val fullTransparentIcon: String? = null,
    val isNullSpray: Boolean = false,
    val levels: List<SprayLevelEntity> = listOf(),
    val themeUuid: String? = null,
    @PrimaryKey val uuid: String = "",
    val timestamp: Long = System.currentTimeMillis()
)