package com.bobbyesp.valapi.library.domain.model.gamemodes


import kotlinx.serialization.Serializable

@Serializable
data class GameRuleBoolOverride(
    val ruleName: String = "",
    val state: Boolean = false
)