package com.bobbyesp.valapi.library.domain.model.weapons


import com.bobbyesp.valapi.library.domain.model.gear.ShopData
import com.bobbyesp.valapi.library.domain.model.weapons.skins.WeaponSkin
import kotlinx.serialization.Serializable

@Serializable
data class Weapon(
    val assetPath: String = "",
    val category: String = "",
    val defaultSkinUuid: String = "",
    val displayIcon: String = "",
    val displayName: String = "",
    val killStreamIcon: String = "",
    val shopData: ShopData? = null,
    val skins: List<WeaponSkin> = listOf(),
    val uuid: String = "",
    val weaponStats: WeaponStats? = null
)