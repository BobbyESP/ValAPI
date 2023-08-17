package com.bobbyesp.valapi.library.domain.model.events


import kotlinx.serialization.Serializable

@Serializable
data class Events(
    val data: List<Event> = listOf(),
    val status: Int = 0
)