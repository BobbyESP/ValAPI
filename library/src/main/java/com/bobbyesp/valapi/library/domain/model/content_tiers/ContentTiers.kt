package com.bobbyesp.valapi.library.domain.model.content_tiers


import kotlinx.serialization.Serializable

@Serializable
data class ContentTiers(
    val data: List<ContentTier> = listOf(),
    val status: Int = 0
)