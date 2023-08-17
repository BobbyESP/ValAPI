package com.bobbyesp.valapi.library.domain.model.weapons


import kotlinx.serialization.Serializable

@Serializable
data class AirBurstStats(
    val burstDistance: Double = 0.0,
    val shotgunPelletCount: Int = 0
)