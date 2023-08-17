package com.bobbyesp.valapi.library.domain.model.weapons


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AltShotgunStats(
    val burstRate: Double = 0.0,
    val shotgunPelletCount: Int = 0
)