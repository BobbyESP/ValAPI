package com.bobbyesp.valapi.library.domain.model.weapons


import kotlinx.serialization.Serializable

@Serializable
data class WeaponStats(
    val adsStats: AdsStats? = null,
    val airBurstStats: AirBurstStats? = null,
    val altFireType: String? = null,
    val altShotgunStats: AltShotgunStats? = null,
    val damageRanges: List<DamageRange> = listOf(),
    val equipTimeSeconds: Double = 0.0,
    val feature: String? = null,
    val fireMode: String? = null,
    val fireRate: Double = 0.0,
    val firstBulletAccuracy: Double = 0.0,
    val magazineSize: Int = 0,
    val reloadTimeSeconds: Double = 0.0,
    val runSpeedMultiplier: Double = 0.0,
    val shotgunPelletCount: Int = 0,
    val wallPenetration: String = ""
)