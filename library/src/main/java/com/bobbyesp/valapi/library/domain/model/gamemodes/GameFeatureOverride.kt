package com.bobbyesp.valapi.library.domain.model.gamemodes


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GameFeatureOverride(
    val featureName: String = "",
    val state: Boolean = false
)