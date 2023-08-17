package com.bobbyesp.valapi.library.domain.model.content_tiers


import kotlinx.serialization.Serializable

@Serializable
data class ContentTier(
    val assetPath: String = "",
    val devName: String = "",
    val displayIcon: String = "",
    val displayName: String = "",
    val highlightColor: String = "",
    val juiceCost: Int = 0,
    val juiceValue: Int = 0,
    val rank: Int = 0,
    val uuid: String = ""
)