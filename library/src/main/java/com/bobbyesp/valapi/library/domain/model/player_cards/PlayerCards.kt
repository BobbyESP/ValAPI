package com.bobbyesp.valapi.library.domain.model.player_cards


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlayerCards(
    val data: List<PlayerCard> = listOf(),
    val status: Int = 0
)