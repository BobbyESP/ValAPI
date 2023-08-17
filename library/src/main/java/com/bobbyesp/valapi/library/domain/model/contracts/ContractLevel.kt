package com.bobbyesp.valapi.library.domain.model.contracts


import kotlinx.serialization.Serializable

@Serializable
data class ContractLevel(
    val doughCost: Int = 0,
    val isPurchasableWithDough: Boolean = false,
    val isPurchasableWithVP: Boolean = false,
    val reward: Reward = Reward(),
    val vpCost: Int = 0,
    val xp: Int = 0
)