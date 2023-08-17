package com.bobbyesp.valapi.library.domain.model.agent

import androidx.room.TypeConverter
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class Ability(
    val description: String = "",
    val displayIcon: String? = null,
    val displayName: String = "",
    val slot: String = ""
)

class AbilityTypeConverter {
    val json = Json {
        ignoreUnknownKeys = true
        encodeDefaults = true
    };

    @TypeConverter
    fun fromJson(jsonString: String): Ability {
        return json.decodeFromString(jsonString);
    }

    @TypeConverter
    fun toJson(value: Ability): String {
        return json.encodeToString(value);
    }

    @TypeConverter
    fun fromJsonList(jsonString: String): List<Ability> {
        return json.decodeFromString(jsonString);
    }

    @TypeConverter
    fun toJsonList(value: List<Ability>): String {
        return json.encodeToString(value);
    }
}