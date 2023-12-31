package com.bobbyesp.valapi.library.converters;

import androidx.room.TypeConverter
import com.bobbyesp.valapi.library.domain.model.weapons.SkinLevel
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class SkinLevelTypeConverters {
    val json = Json {
        ignoreUnknownKeys = true
        encodeDefaults = true
    };

    @TypeConverter
    fun fromJson(jsonString: String): SkinLevel {
        return json.decodeFromString(jsonString);
    }

    @TypeConverter
    fun toJson(value: SkinLevel): String {
        return json.encodeToString(value);
    }

    @TypeConverter
    fun fromJsonList(jsonString: String): List<SkinLevel> {
        return json.decodeFromString(jsonString);
    }

    @TypeConverter
    fun toJsonList(value: List<SkinLevel>): String {
        return json.encodeToString(value);
    }
}