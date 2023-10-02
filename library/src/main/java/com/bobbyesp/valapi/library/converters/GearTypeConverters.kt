package com.bobbyesp.valapi.library.converters;

import androidx.room.TypeConverter
import com.bobbyesp.valapi.library.domain.model.gear.Gear
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class GearTypeConverters {
    val json = Json {
        ignoreUnknownKeys = true
        encodeDefaults = true
    };

    @TypeConverter
    fun fromJson(jsonString: String): Gear {
        return json.decodeFromString(jsonString);
    }

    @TypeConverter
    fun toJson(value: Gear): String {
        return json.encodeToString(value);
    }

    @TypeConverter
    fun fromJsonList(jsonString: String): List<Gear> {
        return json.decodeFromString(jsonString);
    }

    @TypeConverter
    fun toJsonList(value: List<Gear>): String {
        return json.encodeToString(value);
    }
}