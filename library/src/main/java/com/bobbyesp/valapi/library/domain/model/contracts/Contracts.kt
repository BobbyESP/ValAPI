package com.bobbyesp.valapi.library.domain.model.contracts


import kotlinx.serialization.Serializable

@Serializable
data class Contracts(
    val data: List<Contract> = listOf(),
    val status: Int = 0
)