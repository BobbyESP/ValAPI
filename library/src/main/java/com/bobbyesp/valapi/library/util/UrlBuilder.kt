package com.bobbyesp.valapi.library.util

import com.bobbyesp.valapi.library.data.remote.HttpRoutes

object UrlBuilder {
    fun buildUrl(vararg pathSegments: String): String {
        val segments = mutableListOf(HttpRoutes.VALORANT_API_BASE)
        segments.addAll(pathSegments)
        return segments.joinToString("/")
    }

    fun buildUuidUrl(pathTemplate: String, uuid: String): String {
        val pathWithUuid = pathTemplate.replace("{uuid}", uuid)
        return buildUrl(pathWithUuid)
    }
}