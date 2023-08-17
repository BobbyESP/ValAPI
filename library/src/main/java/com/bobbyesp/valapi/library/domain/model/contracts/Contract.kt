package com.bobbyesp.valapi.library.domain.model.contracts


import kotlinx.serialization.Serializable

@Serializable
data class Contract(
    val assetPath: String = "",
    val content: Content = Content(),
    val displayIcon: String? = null,
    val displayName: String = "",
    val freeRewardScheduleUuid: String = "",
    val shipIt: Boolean = false,
    val uuid: String = ""
)