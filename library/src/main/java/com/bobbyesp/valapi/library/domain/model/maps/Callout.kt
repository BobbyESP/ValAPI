package com.bobbyesp.valapi.library.domain.model.maps


import kotlinx.serialization.Serializable

@Serializable
data class Callout(
    val location: Location = Location(),
    val regionName: String = "",
    val superRegionName: String = ""
)