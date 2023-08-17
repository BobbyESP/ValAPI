package com.bobbyesp.valapi.library.domain.model.seasons


import kotlinx.serialization.Serializable

@Serializable
data class Seasons(
    val data: List<Season> = listOf(),
    val status: Int = 0
)