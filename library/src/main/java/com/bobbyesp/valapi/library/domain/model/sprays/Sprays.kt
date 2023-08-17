package com.bobbyesp.valapi.library.domain.model.sprays


import kotlinx.serialization.Serializable

@Serializable
data class Sprays(
    val data: List<Spray> = listOf(),
    val status: Int = 0
)