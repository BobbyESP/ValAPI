package com.bobbyesp.valapi.library.domain.model.buddies

import com.bobbyesp.valapi.library.domain.model.buddies.levels.BuddyLevel
import kotlinx.serialization.Serializable

@Serializable
data class Buddy(
    val uuid: String = "",
    val displayName: String = "",
    val isHiddenIfNotOwned: Boolean = false,
    val themeUuid: String? = null,
    val displayIcon : String = "",
    val assetPath: String = "",
    val levels: List<BuddyLevel> = emptyList()
)
