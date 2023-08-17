package com.bobbyesp.valapi.library.domain.model.agent


import androidx.room.TypeConverter
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class Role(
    val assetPath: String = "",
    val description: String = "",
    val displayIcon: String = "",
    val displayName: String = "",
    val uuid: String = ""
)

class RoleTypeConverters {
    val json = Json {
        ignoreUnknownKeys = true
        encodeDefaults = true
    };

    @TypeConverter
    fun fromJson(jsonString: String): Role {
        return json.decodeFromString(jsonString);
    }

    @TypeConverter
    fun toJson(value: Role): String {
        return json.encodeToString(value);
    }

    @TypeConverter
    fun fromJsonList(jsonString: String): List<Role> {
        return json.decodeFromString(jsonString);
    }

    @TypeConverter
    fun toJsonList(value: List<Role>): String {
        return json.encodeToString(value);
    }
}