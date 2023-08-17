package com.bobbyesp.valapi.library.domain.model.weapons


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GridPosition(
    val column: Int = 0,
    val row: Int = 0
)