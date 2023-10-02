package com.bobbyesp.valapi.library.converters;

import androidx.room.TypeConverter
import com.bobbyesp.valapi.library.domain.model.gamemodes.GameRuleBoolOverride
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class GameRuleBoolOverrideTypeConverters {
    val json = Json {
        ignoreUnknownKeys = true
        encodeDefaults = true
    };

    @TypeConverter
    fun fromJson(jsonString: String): GameRuleBoolOverride {
        return json.decodeFromString(jsonString);
    }

    @TypeConverter
    fun toJson(value: GameRuleBoolOverride): String {
        return json.encodeToString(value);
    }

    @TypeConverter
    fun fromJsonList(jsonString: String): List<GameRuleBoolOverride> {
        return json.decodeFromString(jsonString);
    }

    @TypeConverter
    fun toJsonList(value: List<GameRuleBoolOverride>): String {
        return json.encodeToString(value);
    }
}