package com.bobbyesp.valapi.library.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "currencies")
data class CurrencyEntity(
    val assetPath: String = "",
    val displayIcon: String = "",
    val displayName: String = "",
    val displayNameSingular: String = "",
    val largeIcon: String = "",
    @PrimaryKey val uuid: String = ""
)