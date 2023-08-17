package com.bobbyesp.valapi.library.data.local.database.entity


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bobbyesp.valapi.library.domain.model.weapons.SkinLevel
import com.bobbyesp.valapi.library.domain.model.weapons.skins.chromas.Chroma

@Entity(tableName = "weapon_skins")
data class WeaponSkinEntity(
    val assetPath: String = "",
    val chromas: List<Chroma> = listOf(),
    val contentTierUuid: String? = null,
    val displayIcon: String? = null,
    val displayName: String = "",
    val levels: List<SkinLevel> = listOf(),
    val themeUuid: String = "",
    @PrimaryKey val uuid: String = "",
    val wallpaper: String? = null
)