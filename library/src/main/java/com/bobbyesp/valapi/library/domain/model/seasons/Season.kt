package com.bobbyesp.valapi.library.domain.model.seasons


import kotlinx.serialization.Serializable

@Serializable
data class Season(
    val assetPath: String = "",
    val displayName: String = "",
    val endTime: String = "",
    val parentUuid: String? = null,
    val startTime: String = "",
    val type: String? = null,
    val uuid: String = ""
)