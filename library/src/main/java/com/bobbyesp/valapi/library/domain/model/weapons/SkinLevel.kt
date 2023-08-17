package com.bobbyesp.valapi.library.domain.model.weapons


import kotlinx.serialization.Serializable

@Serializable
data class SkinLevel(
    val assetPath: String = "",
    val displayIcon: String? = null,
    val displayName: String = "",
    val levelItem: String? = null,
    val streamedVideo: String? = null,
    val uuid: String = ""
)