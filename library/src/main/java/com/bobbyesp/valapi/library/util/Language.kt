package com.bobbyesp.valapi.library.util

import java.util.Locale

enum class LanguageCode(val displayName: String) {
    ARABIC_UAE("ar-AE"),
    GERMAN_GERMANY("de-DE"),
    ENGLISH_US("en-US"),
    SPANISH_SPAIN("es-ES"),
    SPANISH_MEXICO("es-MX"),
    FRENCH_FRANCE("fr-FR"),
    INDONESIAN_INDONESIA("id-ID"),
    ITALIAN_ITALY("it-IT"),
    JAPANESE_JAPAN("ja-JP"),
    KOREAN_KOREA("ko-KR"),
    POLISH_POLAND("pl-PL"),
    PORTUGUESE_BRAZIL("pt-BR"),
    RUSSIAN_RUSSIA("ru-RU"),
    THAI_THAILAND("th-TH"),
    TURKISH_TURKEY("tr-TR"),
    VIETNAMESE_VIETNAM("vi-VN"),
    CHINESE_CHINA("zh-CN"),
    CHINESE_TAIWAN("zh-TW");

    override fun toString(): String {
        return displayName
    }
}