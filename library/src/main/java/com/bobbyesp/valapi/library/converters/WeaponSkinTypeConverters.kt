package com.bobbyesp.valapi.library.converters;

import androidx.room.TypeConverter
import com.bobbyesp.valapi.library.domain.model.weapons.skins.WeaponSkin
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class WeaponSkinTypeConverters {
    val json = Json {
        ignoreUnknownKeys = true
        encodeDefaults = true
    };

    @TypeConverter
    fun fromJson(jsonString: String): WeaponSkin {
        return json.decodeFromString(jsonString);
    }

    @TypeConverter
    fun toJson(value: WeaponSkin): String {
        return json.encodeToString(value);
    }

    @TypeConverter
    fun fromJsonList(jsonString: String): List<WeaponSkin> {
        return json.decodeFromString(jsonString);
    }

    @TypeConverter
    fun toJsonList(value: List<WeaponSkin>): String {
        return json.encodeToString(value);
    }
}