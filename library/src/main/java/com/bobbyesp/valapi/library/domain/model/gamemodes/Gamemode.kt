package com.bobbyesp.valapi.library.domain.model.gamemodes


import kotlinx.serialization.Serializable

@Serializable
data class Gamemode(
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
    val uuid: String = ""
)