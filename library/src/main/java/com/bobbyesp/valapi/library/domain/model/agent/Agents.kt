package com.bobbyesp.valapi.library.domain.model.agent


import kotlinx.serialization.Serializable

@Serializable
data class Agents(
    val status: Int = 0,
    val data: List<Agent> = listOf()
)