package com.bobbyesp.valapi.library.data.local.database.entity


import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity(tableName = "versions")
data class VersionEntity(
    val branch: String = "",
    val buildDate: String = "",
    val buildVersion: String = "",
    val engineVersion: String = "",
    @PrimaryKey val manifestId: String = "",
    val riotClientBuild: String = "",
    val riotClientVersion: String = "",
    val version: String = ""
)