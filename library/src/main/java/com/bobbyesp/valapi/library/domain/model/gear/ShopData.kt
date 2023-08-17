package com.bobbyesp.valapi.library.domain.model.gear


import com.bobbyesp.valapi.library.domain.model.weapons.GridPosition
import kotlinx.serialization.Serializable

@Serializable
data class ShopData(
    val assetPath: String = "",
    val canBeTrashed: Boolean = false,
    val category: String = "",
    val categoryText: String = "",
    val cost: Int = 0,
    val gridPosition: GridPosition? = null,
    val image: String? = null,
    val newImage: String = "",
    val newImage2: String? = null
)