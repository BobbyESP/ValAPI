package com.bobbyesp.valapi.library.domain.model.competitive_tiers


import kotlinx.serialization.Serializable

@Serializable
data class CompetitiveTiers(
    val data: List<EpisodeTiers> = listOf(),
    val status: Int = 0
)