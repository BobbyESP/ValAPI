package com.bobbyesp.valapi.library.data.local.database.entity


import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity(tableName = "player_cards")
data class PlayerCardEntity(
    val assetPath: String = "",
    val displayIcon: String = "",
    val displayName: String = "",
    val isHiddenIfNotOwned: Boolean = false,
    val largeArt: String = "",
    val smallArt: String = "",
    val themeUuid: String? = null,
    @PrimaryKey val uuid: String = "",
    val wideArt: String = ""
)