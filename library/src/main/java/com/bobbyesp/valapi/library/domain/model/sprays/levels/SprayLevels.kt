package com.bobbyesp.valapi.library.domain.model.sprays.levels


import com.bobbyesp.valapi.library.domain.model.sprays.SprayLevel
import kotlinx.serialization.Serializable

@Serializable
data class SprayLevels(
    val data: List<SprayLevel> = listOf(),
    val status: Int = 0
)