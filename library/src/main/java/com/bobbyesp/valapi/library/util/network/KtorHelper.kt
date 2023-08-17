package com.bobbyesp.valapi.library.util.network

import com.bobbyesp.valapi.library.data.remote.HttpRoutes
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.serialization.json.Json


suspend inline fun <reified T> makeApiCall(
    client: HttpClient,
    apiUrl: String = HttpRoutes.VALORANT_API_BASE,
    params: Map<String, String>
): T {
    val json = Json {
        ignoreUnknownKeys = true
        encodeDefaults = true
    }

    val response: String = client.get(apiUrl) {
        url {
            params.forEach { (key, value) ->
                parameters.append(key, value)
            }
        }
    }.body()

    return json.decodeFromString<T>(response)
}