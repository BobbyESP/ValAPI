package com.bobbyesp.valapi.library.domain.model.player_titles


import kotlinx.serialization.Serializable

@Serializable
data class PlayerTitles(
    val data: List<PlayerTitle> = listOf(),
    val status: Int = 0
)