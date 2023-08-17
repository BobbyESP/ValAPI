package com.bobbyesp.valapi.library.domain.model.maps


import kotlinx.serialization.Serializable

@Serializable
data class Location(
    val x: Double = 0.0,
    val y: Double = 0.0
)