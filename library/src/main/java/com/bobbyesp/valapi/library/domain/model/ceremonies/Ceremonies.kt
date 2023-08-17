package com.bobbyesp.valapi.library.domain.model.ceremonies


import kotlinx.serialization.Serializable

@Serializable
data class Ceremonies(
    val data: List<Ceremony> = listOf(),
    val status: Int = 0
)