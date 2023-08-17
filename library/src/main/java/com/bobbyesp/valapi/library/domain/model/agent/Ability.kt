package com.bobbyesp.valapi.library.domain.model.agent

import kotlinx.serialization.Serializable

@Serializable
data class Ability(
    val description: String = "",
    val displayIcon: String? = null,
    val displayName: String = "",
    val slot: String = ""
)