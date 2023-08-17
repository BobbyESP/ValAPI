package com.bobbyesp.valapi.library.data.local.database.entity


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bobbyesp.valapi.library.domain.model.maps.Callout
import kotlinx.serialization.Serializable

@Entity(tableName = "maps")
data class MapEntity(
    val assetPath: String = "",
    val callouts: List<Callout>? = null,
    val coordinates: String? = null,
    val displayIcon: String? = null,
    val displayName: String = "",
    val listViewIcon: String = "",
    val mapUrl: String = "",
    val splash: String = "",
    @PrimaryKey val uuid: String = "",
    val xMultiplier: Double = 0.0,
    val xScalarToAdd: Double = 0.0,
    val yMultiplier: Double = 0.0,
    val yScalarToAdd: Double = 0.0
)