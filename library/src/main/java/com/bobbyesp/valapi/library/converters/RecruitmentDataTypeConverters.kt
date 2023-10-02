package com.bobbyesp.valapi.library.converters

import androidx.room.TypeConverter
import com.bobbyesp.valapi.library.domain.model.agent.RecruitmentData
import com.bobbyesp.valapi.library.domain.model.weapons.skins.WeaponSkin
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class RecruitmentDataTypeConverters {
    val json = Json {
        ignoreUnknownKeys = true
        encodeDefaults = true
    };

    @TypeConverter
    fun fromJson(jsonString: String): RecruitmentData {
        return json.decodeFromString(jsonString);
    }

    @TypeConverter
    fun toJson(value: RecruitmentData): String {
        return json.encodeToString(value);
    }

    @TypeConverter
    fun fromJsonList(jsonString: String): List<RecruitmentData> {
        return json.decodeFromString(jsonString);
    }

    @TypeConverter
    fun toJsonList(value: List<RecruitmentData>): String {
        return json.encodeToString(value);
    }
}