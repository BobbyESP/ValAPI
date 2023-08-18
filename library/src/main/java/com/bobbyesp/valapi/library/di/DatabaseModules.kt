package com.bobbyesp.valapi.library.di

import android.content.Context
import androidx.room.Room
import com.bobbyesp.valapi.library.data.local.database.ValAPILibraryDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModules {
    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): ValAPILibraryDb {
        return Room.databaseBuilder(
            context,
            ValAPILibraryDb::class.java,
            ValAPILibraryDb.DATABASE_NAME
        ).build()
    }
}