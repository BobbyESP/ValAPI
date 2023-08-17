package com.bobbyesp.valapi.library.domain.model.agent


import kotlinx.serialization.Serializable

@Serializable
data class Media(
    val id: Int = 0,
    val wave: String = "",
    val wwise: String = ""
)