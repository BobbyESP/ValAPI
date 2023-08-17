package com.bobbyesp.valapi.library.domain.model.bundles


import kotlinx.serialization.Serializable

@Serializable
data class Bundle(
    val assetPath: String = "",
    val description: String = "",
    val displayIcon: String = "",
    val displayIcon2: String = "",
    val displayName: String = "",
    val displayNameSubText: String? = null,
    val extraDescription: String? = null,
    val promoDescription: String? = null,
    val useAdditionalContext: Boolean = false,
    val uuid: String = "",
    val verticalPromoImage: String? = null
)