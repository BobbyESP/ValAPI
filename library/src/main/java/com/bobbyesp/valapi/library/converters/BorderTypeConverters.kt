package com.bobbyesp.valapi.library.converters;

import androidx.room.TypeConverter
import com.bobbyesp.valapi.library.domain.model.seasons.competitive.Border
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class BorderTypeConverters {
    val json = Json {
        ignoreUnknownKeys = true
        encodeDefaults = true
    };

    @TypeConverter
    fun fromJson(jsonString: String): Border {
        return json.decodeFromString(jsonString);
    }

    @TypeConverter
    fun toJson(value: Border): String {
        return json.encodeToString(value);
    }

    @TypeConverter
    fun fromJsonList(jsonString: String): List<Border> {
        return json.decodeFromString(jsonString);
    }

    @TypeConverter
    fun toJsonList(value: List<Border>): String {
        return json.encodeToString(value);
    }
}