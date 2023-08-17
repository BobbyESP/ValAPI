package com.bobbyesp.valapi.library.domain.model.maps


import kotlinx.serialization.Serializable

@Serializable
data class Map(
    val assetPath: String = "",
    val callouts: List<Callout>? = null,
    val coordinates: String? = null,
    val displayIcon: String? = null,
    val displayName: String = "",
    val listViewIcon: String = "",
    val mapUrl: String = "",
    val splash: String = "",
    val uuid: String = "",
    val xMultiplier: Double = 0.0,
    val xScalarToAdd: Double = 0.0,
    val yMultiplier: Double = 0.0,
    val yScalarToAdd: Double = 0.0
)