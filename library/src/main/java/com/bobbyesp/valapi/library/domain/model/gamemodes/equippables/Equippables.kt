package com.bobbyesp.valapi.library.domain.model.gamemodes.equippables


import kotlinx.serialization.Serializable

@Serializable
data class Equippables(
    val data: List<Equippable> = listOf(),
    val status: Int = 0
)