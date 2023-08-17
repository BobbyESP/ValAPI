package com.bobbyesp.valapi.library.domain.model.seasons.competitive


import kotlinx.serialization.Serializable

@Serializable
data class CompetitiveSeason(
    val assetPath: String = "",
    val borders: List<Border>? = null,
    val competitiveTiersUuid: String = "",
    val endTime: String = "",
    val seasonUuid: String = "",
    val startTime: String = "",
    val uuid: String = ""
)