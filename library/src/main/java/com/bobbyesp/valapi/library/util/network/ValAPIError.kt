package com.bobbyesp.valapi.library.util.network

import kotlinx.serialization.Serializable

@Serializable
data class ValAPIError(
    val status: Int = 0,
    val message: String = ""
)
