package com.bobbyesp.valapi.library.converters;

import androidx.room.TypeConverter
import com.bobbyesp.valapi.library.domain.model.gamemodes.GameFeatureOverride
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class GameFeatureOverrideTypeConverters {
    val json = Json {
        ignoreUnknownKeys = true
        encodeDefaults = true
    };

    @TypeConverter
    fun fromJson(jsonString: String): GameFeatureOverride {
        return json.decodeFromString(jsonString);
    }

    @TypeConverter
    fun toJson(value: GameFeatureOverride): String {
        return json.encodeToString(value);
    }

    @TypeConverter
    fun fromJsonList(jsonString: String): List<GameFeatureOverride> {
        return json.decodeFromString(jsonString);
    }

    @TypeConverter
    fun toJsonList(value: List<GameFeatureOverride>): String {
        return json.encodeToString(value);
    }
}