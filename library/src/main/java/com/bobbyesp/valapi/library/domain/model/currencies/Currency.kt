package com.bobbyesp.valapi.library.domain.model.currencies


import kotlinx.serialization.Serializable

@Serializable
data class Currency(
    val assetPath: String = "",
    val displayIcon: String = "",
    val displayName: String = "",
    val displayNameSingular: String = "",
    val largeIcon: String = "",
    val uuid: String = ""
)