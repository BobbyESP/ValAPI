package com.bobbyesp.valapi.library.domain.model.gear


import kotlinx.serialization.Serializable

@Serializable
data class Gear(
    val assetPath: String = "",
    val description: String = "",
    val displayIcon: String = "",
    val displayName: String = "",
    val shopData: ShopData = ShopData(),
    val uuid: String = ""
)