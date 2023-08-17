package com.bobbyesp.valapi.library.domain.model.buddies.levels

import androidx.room.TypeConverter
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class BuddyLevel(
    val uuid: String = "",
    val charmLevel: Int = 0,
    val displayName: String = "",
    val displayIcon: String = "",
    val assetPath: String = ""
)

class BuddyLevelTypeConverters {
    val json = Json {
        ignoreUnknownKeys = true
        encodeDefaults = true
    };

    @TypeConverter
    fun fromJson(jsonString: String): BuddyLevel {
        return json.decodeFromString(jsonString);
    }

    @TypeConverter
    fun toJson(value: BuddyLevel): String {
        return json.encodeToString(value);
    }

    @TypeConverter
    fun fromJsonList(jsonString: String): List<BuddyLevel> {
        return json.decodeFromString(jsonString);
    }

    @TypeConverter
    fun toJsonList(value: List<BuddyLevel>): String {
        return json.encodeToString(value);
    }
}
