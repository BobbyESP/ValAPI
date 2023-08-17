package com.bobbyesp.valapi.library.data.local.database.entity


import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity(tableName = "level_borders")
data class LevelBorderEntity(
    val assetPath: String = "",
    val levelNumberAppearance: String = "",
    val smallPlayerCardAppearance: String = "",
    val startingLevel: Int = 0,
    @PrimaryKey val uuid: String = ""
)