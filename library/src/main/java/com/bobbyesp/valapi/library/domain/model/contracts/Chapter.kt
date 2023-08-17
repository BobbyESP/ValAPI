package com.bobbyesp.valapi.library.domain.model.contracts


import kotlinx.serialization.Serializable

@Serializable
data class Chapter(
    val freeRewards: List<FreeReward>? = null,
    val isEpilogue: Boolean = false,
    val levels: List<ContractLevel> = listOf()
)