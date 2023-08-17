package com.bobbyesp.valapi.library.domain.model.weapons


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DamageRange(
    val bodyDamage: Int = 0,
    val headDamage: Double = 0.0,
    val legDamage: Double = 0.0,
    val rangeEndMeters: Int = 0,
    val rangeStartMeters: Int = 0
)