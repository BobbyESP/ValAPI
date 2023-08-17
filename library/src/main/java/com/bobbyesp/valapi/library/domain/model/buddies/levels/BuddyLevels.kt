package com.bobbyesp.valapi.library.domain.model.buddies.levels

import kotlinx.serialization.Serializable

@Serializable
data class BuddyLevels(
    val data: List<BuddyLevel> = emptyList(),
    val status: Int = 0
)
