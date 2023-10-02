package com.bobbyesp.valapi.library.converters;

import androidx.room.TypeConverter
import com.bobbyesp.valapi.library.domain.model.weapons.WeaponStats
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class WeaponStatsTypeConverters {
    val json = Json {
        ignoreUnknownKeys = true
        encodeDefaults = true
    };

    @TypeConverter
    fun fromJson(jsonString: String): WeaponStats {
        return json.decodeFromString(jsonString);
    }

    @TypeConverter
    fun toJson(value: WeaponStats): String {
        return json.encodeToString(value);
    }

    @TypeConverter
    fun fromJsonList(jsonString: String): List<WeaponStats> {
        return json.decodeFromString(jsonString);
    }

    @TypeConverter
    fun toJsonList(value: List<WeaponStats>): String {
        return json.encodeToString(value);
    }
}