package com.bobbyesp.valapi.library.data.local.database.entity


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bobbyesp.valapi.library.domain.model.gamemodes.GameFeatureOverride
import com.bobbyesp.valapi.library.domain.model.gamemodes.GameRuleBoolOverride

@Entity(tableName = "gamemodes")
data class GamemodeEntity(
    val allowsMatchTimeouts: Boolean = false,
    val assetPath: String = "",
    val displayIcon: String? = null,
    val displayName: String = "",
    val duration: String? = null,
    val gameFeatureOverrides: List<GameFeatureOverride>? = null,
    val gameRuleBoolOverrides: List<GameRuleBoolOverride>? = null,
    val isMinimapHidden: Boolean = false,
    val isTeamVoiceAllowed: Boolean = false,
    val orbCount: Int = 0,
    val roundsPerHalf: Int = 0,
    val teamRoles: List<String>? = null,
    @PrimaryKey val uuid: String = "",
    val timestamp: Long = System.currentTimeMillis()
)