package com.bobbyesp.valapi.library.data.repository

import com.bobbyesp.valapi.library.data.local.database.ValAPILibraryDb
import com.bobbyesp.valapi.library.data.local.database.entity.BuddyEntity.Companion.toBuddy
import com.bobbyesp.valapi.library.data.local.database.entity.BuddyEntity.Companion.toEntity
import com.bobbyesp.valapi.library.data.local.database.entity.BuddyLevelEntity.Companion.toBuddyLevel
import com.bobbyesp.valapi.library.domain.model.buddies.Buddy
import com.bobbyesp.valapi.library.domain.model.buddies.levels.BuddyLevel
import com.bobbyesp.valapi.library.domain.respository.ValorantAPI
import com.bobbyesp.valapi.library.domain.respository.agents.BuddiesAPI
import com.bobbyesp.valapi.library.util.LanguageCode
import com.bobbyesp.valapi.library.util.data.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class BuddiesImpl @Inject constructor(
    private val valorantAPI: ValorantAPI,
    private val valApiDb: ValAPILibraryDb
): BuddiesAPI {
    override suspend fun getBuddies(language: LanguageCode): Flow<Resource<List<Buddy>>> = flow {
        emit(Resource.Loading())

        val cachedResponse = valApiDb.buddyDao().getAll().map {
            it.toBuddy()
        }

        if (cachedResponse.isNotEmpty()) {
            emit(Resource.Success(cachedResponse))
        } else {
            try {
                val response = valorantAPI.getBuddies(language)

                for (buddy in response.data) {
                    valApiDb.buddyDao().insert(buddy.toEntity())
                }
                emit(Resource.Success(response.data))
            } catch (e: Throwable) {
                emit(Resource.Error(e.localizedMessage ?: e.stackTraceToString()))
            }
        }
    }

    override suspend fun getBuddyLevels(language: LanguageCode): Flow<Resource<List<BuddyLevel>>> = flow {
        emit(Resource.Loading())

        val cachedResponse = valApiDb.buddyDao().getAllBuddyLevels().map {
            it.toBuddyLevel()
        }

        if (cachedResponse.isNotEmpty()) {
            emit(Resource.Success(cachedResponse))
        } else {
            try {
                val response = valorantAPI.getBuddyLevels(language)

                for (buddyLevel in response.data) {
                    valApiDb.buddyDao().insertBuddyLevel(
                        uuid = buddyLevel.uuid,
                        charmLevel = buddyLevel.charmLevel,
                        displayName = buddyLevel.displayName,
                        displayIcon = buddyLevel.displayIcon,
                        assetPath = buddyLevel.assetPath
                    )
                }
                emit(Resource.Success(response.data))
            } catch (e: Throwable) {
                emit(Resource.Error(e.localizedMessage ?: e.stackTraceToString()))
            }
        }
    }

    override suspend fun getBuddyByUuid(
        language: LanguageCode,
        uuid: String
    ): Flow<Resource<Buddy>> = flow {
        emit(Resource.Loading())

        val cachedResponse = valApiDb.buddyDao().getBuddyByUuid(uuid)?.toBuddy()

        if (cachedResponse != null) {
            emit(Resource.Success(cachedResponse))
        } else {
            try {
                val response = valorantAPI.getBuddyByUuid(language, uuid)
                valApiDb.buddyDao().insert(response.toEntity())
                emit(Resource.Success(response))
            } catch (e: Throwable) {
                emit(Resource.Error(e.localizedMessage ?: e.stackTraceToString()))
            }
        }
    }

    override suspend fun getBuddyLevelByUuid(
        language: LanguageCode,
        uuid: String
    ): Flow<Resource<BuddyLevel>> = flow {
        emit(Resource.Loading())

        val cachedResponse = valApiDb.buddyDao().getBuddyLevelByUuid(uuid)?.toBuddyLevel()

        if (cachedResponse != null) {
            emit(Resource.Success(cachedResponse))
        } else {
            try {
                val response = valorantAPI.getBuddyLevelByUuid(language, uuid)
                valApiDb.buddyDao().insertBuddyLevel(
                    uuid = response.uuid,
                    charmLevel = response.charmLevel,
                    displayName = response.displayName,
                    displayIcon = response.displayIcon,
                    assetPath = response.assetPath
                )
                emit(Resource.Success(response))
            } catch (e: Throwable) {
                emit(Resource.Error(e.localizedMessage ?: e.stackTraceToString()))
            }
        }
    }

}