package com.bobbyesp.valapi.library.domain.model.seasons.competitive


import kotlinx.serialization.Serializable

@Serializable
data class Border(
    val assetPath: String = "",
    val displayIcon: String = "",
    val level: Int = 0,
    val smallIcon: String? = null,
    val uuid: String = "",
    val winsRequired: Int = 0
)