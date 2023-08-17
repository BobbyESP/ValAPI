package com.bobbyesp.valapi.library.domain.model.themes


import kotlinx.serialization.Serializable

@Serializable
data class Theme(
    val assetPath: String = "",
    val displayIcon: String? = null,
    val displayName: String = "",
    val storeFeaturedImage: String? = null,
    val uuid: String = ""
)