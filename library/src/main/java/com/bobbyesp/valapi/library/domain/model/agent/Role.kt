package com.bobbyesp.valapi.library.domain.model.agent


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Role(
    val assetPath: String = "",
    val description: String = "",
    val displayIcon: String = "",
    val displayName: String = "",
    val uuid: String = ""
)