package com.bobbyesp.valapi.library.domain.model.gamemodes


import kotlinx.serialization.Serializable

@Serializable
data class Gamemodes(
    val data: List<Gamemode> = listOf(),
    val status: Int = 0
)