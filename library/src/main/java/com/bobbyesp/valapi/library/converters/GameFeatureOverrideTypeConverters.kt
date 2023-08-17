package com.bobbyesp.valapi.library.domain.model.gamemodes;

import androidx.room.TypeConverter
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class GameFeatureOverrideTypeConverters {
    val json = Json {
        ignoreUnknownKeys = true
        encodeDefaults = true
    };

    @TypeConverter
    fun fromJson(jsonString: String): com.bobbyesp.valapi.library.domain.model.gamemodes.GameFeatureOverride {
        return json.decodeFromString(jsonString);
    }

    @TypeConverter
    fun toJson(value: com.bobbyesp.valapi.library.domain.model.gamemodes.GameFeatureOverride): String {
        return json.encodeToString(value);
    }

    @TypeConverter
    fun fromJsonList(jsonString: String): List<com.bobbyesp.valapi.library.domain.model.gamemodes.GameFeatureOverride> {
        return json.decodeFromString(jsonString);
    }

    @TypeConverter
    fun toJsonList(value: List<com.bobbyesp.valapi.library.domain.model.gamemodes.GameFeatureOverride>): String {
        return json.encodeToString(value);
    }
}