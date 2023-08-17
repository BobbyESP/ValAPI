package com.bobbyesp.valapi.library.domain.model.competitive_tiers


import kotlinx.serialization.Serializable

@Serializable
data class CompetitiveTier(
    val backgroundColor: String = "",
    val color: String = "",
    val division: String = "",
    val divisionName: String = "",
    val largeIcon: String? = null,
    val rankTriangleDownIcon: String? = null,
    val rankTriangleUpIcon: String? = null,
    val smallIcon: String? = null,
    val tier: Int = 0,
    val tierName: String = ""
)