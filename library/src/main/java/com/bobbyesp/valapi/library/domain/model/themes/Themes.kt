package com.bobbyesp.valapi.library.domain.model.themes


import kotlinx.serialization.Serializable

@Serializable
data class Themes(
    val data: List<Theme> = listOf(),
    val status: Int = 0
)