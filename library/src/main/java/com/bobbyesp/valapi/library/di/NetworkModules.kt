package com.bobbyesp.valapi.library.di

import androidx.compose.ui.viewinterop.AndroidView
import com.bobbyesp.valapi.library.domain.respository.ValorantAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.cache.HttpCache
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModules {

    @Provides
    @Singleton
    fun provideValorantApi(): ValorantAPI {
        return ValorantAPI.create()
    }

    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient {
        return HttpClient(Android) {
            install(Logging) { // Install default logger for Ktor
                level = LogLevel.ALL
            }
            install(ContentNegotiation) { // Install JSON serializer using Kotlinx serialization
                json(
                    contentType = ContentType.Application.Json,
                    json = Json {
                        ignoreUnknownKeys = true
                        encodeDefaults = true
                    }
                )
            }
            install(HttpCache) // Install default cache (in-memory)
        }
    }
}