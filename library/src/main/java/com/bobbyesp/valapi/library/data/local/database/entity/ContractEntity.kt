package com.bobbyesp.valapi.library.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.bobbyesp.valapi.library.domain.model.contracts.Content
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Entity(tableName = "contracts")
data class ContractEntity(
    val assetPath: String = "",
    val content: Content = Content(),
    val displayIcon: String? = null,
    val displayName: String = "",
    val freeRewardScheduleUuid: String = "",
    val shipIt: Boolean = false,
    @PrimaryKey val uuid: String = ""
)

class ContentTypeConverters {
    val json = Json {
        ignoreUnknownKeys = true
        encodeDefaults = true
    };

    @TypeConverter
    fun fromJson(jsonString: String): Content {
        return json.decodeFromString(jsonString);
    }

    @TypeConverter
    fun toJson(value: Content): String {
        return json.encodeToString(value);
    }

    @TypeConverter
    fun fromJsonList(jsonString: String): List<Content> {
        return json.decodeFromString(jsonString);
    }

    @TypeConverter
    fun toJsonList(value: List<Content>): String {
        return json.encodeToString(value);
    }
}
