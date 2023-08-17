package com.bobbyesp.valapi.library.domain.model.weapons.skins


import com.bobbyesp.valapi.library.domain.model.weapons.skins.chromas.Chroma
import com.bobbyesp.valapi.library.domain.model.weapons.WeaponLevel
import kotlinx.serialization.Serializable

@Serializable
data class WeaponSkin(
    val assetPath: String = "",
    val chromas: List<Chroma> = listOf(),
    val contentTierUuid: String? = null,
    val displayIcon: String? = null,
    val displayName: String = "",
    val levels: List<WeaponLevel> = listOf(),
    val themeUuid: String = "",
    val uuid: String = "",
    val wallpaper: String? = null
)