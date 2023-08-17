package com.bobbyesp.valapi.library.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bundles")
data class BundleEntity(
    @PrimaryKey val uuid: String = "",
    val assetPath: String = "",
    val description: String = "",
    val displayIcon: String = "",
    val displayIcon2: String = "",
    val displayName: String = "",
    val displayNameSubText: String? = null,
    val extraDescription: String? = null,
    val promoDescription: String? = null,
    val useAdditionalContext: Boolean = false,
    val verticalPromoImage: String? = null
)
