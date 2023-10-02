package com.bobbyesp.valapi.library.converters;

import androidx.room.TypeConverter
import com.bobbyesp.valapi.library.domain.model.gear.ShopData
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class ShopDataTypeConverters {
    val json = Json {
        ignoreUnknownKeys = true
        encodeDefaults = true
    };

    @TypeConverter
    fun fromJson(jsonString: String): ShopData {
        return json.decodeFromString(jsonString);
    }

    @TypeConverter
    fun toJson(value: ShopData): String {
        return json.encodeToString(value);
    }

    @TypeConverter
    fun fromJsonList(jsonString: String): List<ShopData> {
        return json.decodeFromString(jsonString);
    }

    @TypeConverter
    fun toJsonList(value: List<ShopData>): String {
        return json.encodeToString(value);
    }
}