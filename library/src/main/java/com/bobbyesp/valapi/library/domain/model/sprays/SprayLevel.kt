package com.bobbyesp.valapi.library.domain.model.sprays


import kotlinx.serialization.Serializable

@Serializable
data class SprayLevel(
    val assetPath: String = "",
    val displayIcon: String? = null,
    val displayName: String = "",
    val sprayLevel: Int = 0,
    val uuid: String = ""
)