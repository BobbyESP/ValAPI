package com.bobbyesp.valapi.library.data.local.database.entity


import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity(tableName = "themes")
data class ThemeEntity(
    val assetPath: String = "",
    val displayIcon: String? = null,
    val displayName: String = "",
    val storeFeaturedImage: String? = null,
    @PrimaryKey val uuid: String = ""
)