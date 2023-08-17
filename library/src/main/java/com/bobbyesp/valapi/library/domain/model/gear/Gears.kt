package com.bobbyesp.valapi.library.domain.model.gear


import kotlinx.serialization.Serializable

@Serializable
data class Gears(
    val data: List<Gear> = listOf(),
    val status: Int = 0
)