package com.bobbyesp.valapi.library.domain.model.buddies.levels

import kotlinx.serialization.Serializable

@Serializable
data class BuddyLevel(
    val uuid: String = "",
    val charmLevel: Int = 0,
    val displayName: String = "",
    val displayIcon: String = "",
    val assetPath: String = ""
)
