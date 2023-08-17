package com.bobbyesp.valapi.library.domain.model.currencies


import kotlinx.serialization.Serializable

@Serializable
data class Currencies(
    val data: List<Currency> = listOf(),
    val status: Int = 0
)