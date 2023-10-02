package com.bobbyesp.valapi.library.converters;

import androidx.room.TypeConverter
import com.bobbyesp.valapi.library.data.local.database.entity.SprayLevelEntity
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class SprayLevelEntityTypeConverters {
    val json = Json {
        ignoreUnknownKeys = true
        encodeDefaults = true
    };

    @TypeConverter
    fun fromJson(jsonString: String): SprayLevelEntity {
        return json.decodeFromString(jsonString);
    }

    @TypeConverter
    fun toJson(value: SprayLevelEntity): String {
        return json.encodeToString(value);
    }

    @TypeConverter
    fun fromJsonList(jsonString: String): List<SprayLevelEntity> {
        return json.decodeFromString(jsonString);
    }

    @TypeConverter
    fun toJsonList(value: List<SprayLevelEntity>): String {
        return json.encodeToString(value);
    }
}