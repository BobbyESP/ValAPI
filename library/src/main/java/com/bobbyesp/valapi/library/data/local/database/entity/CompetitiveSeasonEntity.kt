package com.bobbyesp.valapi.library.data.local.database.entity


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bobbyesp.valapi.library.domain.model.seasons.competitive.Border

@Entity(tableName = "competitive_seasons")
data class CompetitiveSeasonEntity(
    val assetPath: String = "",
    val borders: List<Border>? = null,
    val competitiveTiersUuid: String = "",
    val endTime: String = "",
    val seasonUuid: String = "",
    val startTime: String = "",
    @PrimaryKey val uuid: String = ""
)