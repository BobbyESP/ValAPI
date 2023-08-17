package com.bobbyesp.valapi.library.domain.model.bundles


import kotlinx.serialization.Serializable

@Serializable
data class Bundles(
    val data: List<Bundle> = listOf(),
    val status: Int = 0
)