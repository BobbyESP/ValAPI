package com.bobbyesp.valapi.library.domain.model.agent


import androidx.room.TypeConverter
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class VoiceLine(
    val maxDuration: Double = 0.0,
    val mediaList: List<Media> = listOf(),
    val minDuration: Double = 0.0
)

class VoiceLineTypeConverter {
    val json = Json {
        ignoreUnknownKeys = true
        encodeDefaults = true
    };

    @TypeConverter
    fun fromJson(jsonString: String): VoiceLine {
        return json.decodeFromString(jsonString);
    }

    @TypeConverter
    fun toJson(value: VoiceLine): String {
        return json.encodeToString(value);
    }

    @TypeConverter
    fun fromJsonList(jsonString: String): List<VoiceLine> {
        return json.decodeFromString(jsonString);
    }

    @TypeConverter
    fun toJsonList(value: List<VoiceLine>): String {
        return json.encodeToString(value);
    }
}