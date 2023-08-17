package com.bobbyesp.valapi.library.domain.model.level_borders


import kotlinx.serialization.Serializable

@Serializable
data class LevelBorders(
    val `data`: List<LevelBorder> = listOf(),
    val status: Int = 0
)