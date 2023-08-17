package com.bobbyesp.valapi.library.domain.model.weapons.skins


import kotlinx.serialization.Serializable

@Serializable
data class WeaponSkins(
    val `data`: List<WeaponSkin> = listOf(),
    val status: Int = 0
)