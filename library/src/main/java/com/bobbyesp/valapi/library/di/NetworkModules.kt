package com.bobbyesp.valapi.library.di

import com.bobbyesp.valapi.library.domain.respository.ValorantAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModules {

    @Provides
    @Singleton
    fun provideValorantApi(): ValorantAPI {
        return ValorantAPI.create()
    }
}