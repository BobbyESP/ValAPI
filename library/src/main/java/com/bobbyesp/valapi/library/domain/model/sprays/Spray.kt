package com.bobbyesp.valapi.library.domain.model.sprays


import kotlinx.serialization.Serializable

@Serializable
data class Spray(
    val animationGif: String? = null,
    val animationPng: String? = null,
    val assetPath: String = "",
    val category: String? = null,
    val displayIcon: String = "",
    val displayName: String = "",
    val fullIcon: String? = null,
    val fullTransparentIcon: String? = null,
    val isNullSpray: Boolean = false,
    val levels: List<SprayLevel> = listOf(),
    val themeUuid: String? = null,
    val uuid: String = ""
)