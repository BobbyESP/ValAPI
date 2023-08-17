package com.bobbyesp.valapi.library.domain.model.player_titles


import kotlinx.serialization.Serializable

@Serializable
data class PlayerTitle(
    val assetPath: String = "",
    val displayName: String? = null,
    val isHiddenIfNotOwned: Boolean = false,
    val titleText: String? = null,
    val uuid: String = ""
)