package com.bobbyesp.valapi.library.domain.model.events


import kotlinx.serialization.Serializable

@Serializable
data class Event(
    val assetPath: String = "",
    val displayName: String = "",
    val endTime: String = "",
    val shortDisplayName: String = "",
    val startTime: String = "",
    val uuid: String = ""
)