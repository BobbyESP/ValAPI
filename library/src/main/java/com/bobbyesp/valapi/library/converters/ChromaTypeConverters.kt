package com.bobbyesp.valapi.library.converters;

import androidx.room.TypeConverter
import com.bobbyesp.valapi.library.domain.model.weapons.skins.chromas.Chroma
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class ChromaTypeConverters {
    val json = Json {
        ignoreUnknownKeys = true
        encodeDefaults = true
    };

    @TypeConverter
    fun fromJson(jsonString: String): Chroma {
        return json.decodeFromString(jsonString);
    }

    @TypeConverter
    fun toJson(value: Chroma): String {
        return json.encodeToString(value);
    }

    @TypeConverter
    fun fromJsonList(jsonString: String): List<Chroma> {
        return json.decodeFromString(jsonString);
    }

    @TypeConverter
    fun toJsonList(value: List<Chroma>): String {
        return json.encodeToString(value);
    }
}