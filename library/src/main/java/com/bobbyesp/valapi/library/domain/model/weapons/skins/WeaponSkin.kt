package com.bobbyesp.valapi.library.domain.model.weapons.skins


import com.bobbyesp.valapi.library.domain.model.weapons.SkinLevel
import com.bobbyesp.valapi.library.domain.model.weapons.skins.chromas.Chroma
import kotlinx.serialization.Serializable

@Serializable
data class WeaponSkin(
    val assetPath: String = "",
    val chromas: List<Chroma> = listOf(),
    val contentTierUuid: String? = null,
    val displayIcon: String? = null,
    val displayName: String = "",
    val levels: List<SkinLevel> = listOf(),
    val themeUuid: String = "",
    val uuid: String = "",
    val wallpaper: String? = null
)