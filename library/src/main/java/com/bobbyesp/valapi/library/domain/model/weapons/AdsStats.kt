package com.bobbyesp.valapi.library.domain.model.weapons


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AdsStats(
    val burstCount: Int = 0,
    val fireRate: Double = 0.0,
    val firstBulletAccuracy: Double = 0.0,
    val runSpeedMultiplier: Double = 0.0,
    val zoomMultiplier: Double = 0.0
)