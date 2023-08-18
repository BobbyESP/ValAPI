package com.bobbyesp.valapi.library.util.network

import com.bobbyesp.valapi.library.data.remote.HttpRoutes
import com.bobbyesp.valapi.library.util.throwables.ValAPIParsingError
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.serialization.json.Json

@Throws(ValAPIParsingError::class)
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

    return try {
        json.decodeFromString<T>(response)
    } catch (e: Exception) {
        //get error code from response string with json field "status"
        val errorCode = json.decodeFromString<ValAPIError>(response).status
        throw ValAPIParsingError(
            message = "Error parsing response from $apiUrl",
            errorCode = errorCode,
            response = response
        )
    }
}