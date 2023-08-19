package com.bobbyesp.valapi.library.domain.respository.agents

import com.bobbyesp.valapi.library.domain.model.buddies.Buddies
import com.bobbyesp.valapi.library.domain.model.buddies.Buddy
import com.bobbyesp.valapi.library.domain.model.buddies.levels.BuddyLevel
import com.bobbyesp.valapi.library.domain.model.buddies.levels.BuddyLevels
import com.bobbyesp.valapi.library.util.LanguageCode
import com.bobbyesp.valapi.library.util.data.Resource
import kotlinx.coroutines.flow.Flow

interface BuddiesAPI {
    suspend fun getBuddies(
        language: LanguageCode = LanguageCode.ENGLISH_US
    ): Flow<Resource<List<Buddy>>>

    suspend fun getBuddyLevels(
        language: LanguageCode = LanguageCode.ENGLISH_US,
    ): Flow<Resource<List<BuddyLevel>>>

    suspend fun getBuddyByUuid(
        language: LanguageCode = LanguageCode.ENGLISH_US,
        uuid: String
    ): Flow<Resource<Buddy>>

    suspend fun getBuddyLevelByUuid(
        language: LanguageCode = LanguageCode.ENGLISH_US,
        uuid: String
    ): Flow<Resource<BuddyLevel>>
}