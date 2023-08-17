package com.bobbyesp.valapi.library.domain.model.weapons.skins.chromas


import kotlinx.serialization.Serializable

@Serializable
data class Chroma(
    val assetPath: String = "",
    val displayIcon: String? = null,
    val displayName: String = "",
    val fullRender: String = "",
    val streamedVideo: String? = null,
    val swatch: String? = null,
    val uuid: String = ""
)