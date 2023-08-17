package com.bobbyesp.valapi.library.domain.model.contracts


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Reward(
    val amount: Int = 0,
    val isHighlighted: Boolean = false,
    val type: String = "",
    val uuid: String = ""
)