package com.bobbyesp.valapi.library.domain.model.contracts


import kotlinx.serialization.Serializable

@Serializable
data class Content(
    val chapters: List<Chapter> = listOf(),
    val premiumRewardScheduleUuid: String? = null,
    val premiumVPCost: Int = 0,
    val relationType: String? = null,
    val relationUuid: String? = null
)