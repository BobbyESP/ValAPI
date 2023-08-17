package com.bobbyesp.valapi.library.domain.model.gamemodes.equippables


import kotlinx.serialization.Serializable

@Serializable
data class Equippable(
    val assetPath: String = "",
    val category: String = "",
    val displayIcon: String = "",
    val displayName: String = "",
    val killStreamIcon: String = "",
    val uuid: String = ""
)