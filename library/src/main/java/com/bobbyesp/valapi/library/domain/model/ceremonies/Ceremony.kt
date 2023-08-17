package com.bobbyesp.valapi.library.domain.model.ceremonies


import kotlinx.serialization.Serializable

@Serializable
data class Ceremony(
    val assetPath: String = "",
    val displayName: String = "",
    val uuid: String = ""
)