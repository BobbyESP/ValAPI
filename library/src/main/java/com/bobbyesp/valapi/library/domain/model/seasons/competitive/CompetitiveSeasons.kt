package com.bobbyesp.valapi.library.domain.model.seasons.competitive


import kotlinx.serialization.Serializable

@Serializable
data class CompetitiveSeasons(
    val data: List<CompetitiveSeason> = listOf(),
    val status: Int = 0
)