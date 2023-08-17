package com.bobbyesp.valapi.library.domain.model.agent


import kotlinx.serialization.Serializable

@Serializable
data class VoiceLine(
    val maxDuration: Double = 0.0,
    val mediaList: List<Media> = listOf(),
    val minDuration: Double = 0.0
)