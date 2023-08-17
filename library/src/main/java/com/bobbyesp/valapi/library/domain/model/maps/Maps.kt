package com.bobbyesp.valapi.library.domain.model.maps


import kotlinx.serialization.Serializable

@Serializable
data class Maps(
    val data: List<Map> = listOf(),
    val status: Int = 0
)