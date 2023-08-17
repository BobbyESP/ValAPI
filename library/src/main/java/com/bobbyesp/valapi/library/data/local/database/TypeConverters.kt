package com.bobbyesp.valapi.library.data.local.database

import android.net.Uri
import androidx.room.TypeConverter

class DbTypeConverters {
    @TypeConverter
    fun fromString(value: String?): List<String>? {
        return value?.split(",")
    }

    @TypeConverter
    fun toString(value: List<String>?): String? {
        return value?.joinToString(",")
    }

    @TypeConverter
    fun fromUri(value: Uri?): String? {
        return value?.toString()
    }

    @TypeConverter
    fun toUri(value: String?): Uri? {
        return value?.let { Uri.parse(it) }
    }
}