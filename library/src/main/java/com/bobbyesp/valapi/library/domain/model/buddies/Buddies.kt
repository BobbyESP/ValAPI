package com.bobbyesp.valapi.library.domain.model.buddies

import kotlinx.serialization.Serializable

@Serializable
data class Buddies(
    val data: List<Buddy> = emptyList(),
    val status: Int = 0
)
