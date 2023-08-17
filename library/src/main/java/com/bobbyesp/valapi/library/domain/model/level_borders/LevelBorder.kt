package com.bobbyesp.valapi.library.domain.model.level_borders


import kotlinx.serialization.Serializable

@Serializable
data class LevelBorder(
    val assetPath: String = "",
    val levelNumberAppearance: String = "",
    val smallPlayerCardAppearance: String = "",
    val startingLevel: Int = 0,
    val uuid: String = ""
)