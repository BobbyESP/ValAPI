package com.bobbyesp.valapi.library.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "competitive_tiers")
data class CompetitiveTierEntity(
    val backgroundColor: String = "",
    val color: String = "",
    val division: String = "",
    val divisionName: String = "",
    val largeIcon: String? = null,
    val rankTriangleDownIcon: String? = null,
    val rankTriangleUpIcon: String? = null,
    val smallIcon: String? = null,
    val tier: Int = 0,
    @PrimaryKey val tierName: String = ""
)
