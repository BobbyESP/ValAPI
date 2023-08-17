package com.bobbyesp.valapi.library.domain.model.competitive_tiers


import kotlinx.serialization.Serializable

@Serializable
data class EpisodeTiers(
    val assetObjectName: String = "",
    val assetPath: String = "",
    val tiers: List<CompetitiveTier> = listOf(),
    val uuid: String = ""
)