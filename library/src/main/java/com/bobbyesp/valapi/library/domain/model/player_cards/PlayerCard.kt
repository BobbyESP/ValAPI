package com.bobbyesp.valapi.library.domain.model.player_cards


import kotlinx.serialization.Serializable

@Serializable
data class PlayerCard(
    val assetPath: String = "",
    val displayIcon: String = "",
    val displayName: String = "",
    val isHiddenIfNotOwned: Boolean = false,
    val largeArt: String = "",
    val smallArt: String = "",
    val themeUuid: String? = null,
    val uuid: String = "",
    val wideArt: String = ""
)