package com.bobbyesp.valapi.library.converters;

import androidx.room.TypeConverter
import com.bobbyesp.valapi.library.domain.model.maps.Callout
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class CalloutTypeConverters {
    val json = Json {
        ignoreUnknownKeys = true
        encodeDefaults = true
    };

    @TypeConverter
    fun fromJson(jsonString: String): Callout {
        return json.decodeFromString(jsonString);
    }

    @TypeConverter
    fun toJson(value: Callout): String {
        return json.encodeToString(value);
    }

    @TypeConverter
    fun fromJsonList(jsonString: String): List<Callout> {
        return json.decodeFromString(jsonString);
    }

    @TypeConverter
    fun toJsonList(value: List<Callout>): String {
        return json.encodeToString(value);
    }
}