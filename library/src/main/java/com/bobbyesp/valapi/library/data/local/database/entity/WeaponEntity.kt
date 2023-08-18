package com.bobbyesp.valapi.library.data.local.database.entity


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bobbyesp.valapi.library.domain.model.gear.ShopData
import com.bobbyesp.valapi.library.domain.model.weapons.WeaponStats
import com.bobbyesp.valapi.library.domain.model.weapons.skins.WeaponSkin

@Entity(tableName = "weapons")
data class WeaponEntity(
    val assetPath: String = "",
    val category: String = "",
    val defaultSkinUuid: String = "",
    val displayIcon: String = "",
    val displayName: String = "",
    val killStreamIcon: String = "",
    val shopData: ShopData? = null,
    val skins: List<WeaponSkin> = listOf(),
    @PrimaryKey val uuid: String = "",
    val weaponStats: WeaponStats? = null,
    val timestamp: Long = System.currentTimeMillis()
)