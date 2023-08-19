package com.bobbyesp.valapi.library.data.repository

import android.util.Log
import com.bobbyesp.valapi.library.data.local.database.ValAPILibraryDb
import com.bobbyesp.valapi.library.data.local.database.entity.AgentEntity.Companion.toAgent
import com.bobbyesp.valapi.library.data.local.database.entity.AgentEntity.Companion.toAgentEntity
import com.bobbyesp.valapi.library.domain.model.agent.Agent
import com.bobbyesp.valapi.library.domain.respository.ValorantAPI
import com.bobbyesp.valapi.library.domain.respository.agents.AgentsAPI
import com.bobbyesp.valapi.library.util.LanguageCode
import com.bobbyesp.valapi.library.util.data.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AgentsImpl @Inject constructor(
    private val valorantAPI: ValorantAPI,
    private val valApiDb: ValAPILibraryDb
) : AgentsAPI {
    override suspend fun getAgents(
        language: LanguageCode,
        isCharacterPlayable: Boolean
    ): Flow<Resource<List<Agent>>> = flow {
        emit(Resource.Loading())

        val cachedResponse = valApiDb.agentDao().getAll(languageCode = language).map {
            Log.i("AgentsImpl", "getAgents: ${it.language}")
            it.toAgent()
        }

        if (cachedResponse.isNotEmpty()) {
            emit(Resource.Success(cachedResponse))
        } else {
            try {
                val response = valorantAPI.getAgents(language, isCharacterPlayable)

                for (agent in response.data) {
                    valApiDb.agentDao().insert(agent.toAgentEntity(language))
                }
                emit(Resource.Success(response.data))
            } catch (e: Throwable) {
                emit(Resource.Error(e.localizedMessage ?: e.stackTraceToString()))
            }
        }

    }

    override suspend fun getAgentByUuid(
        language: LanguageCode,
        uuid: String
    ): Flow<Resource<Agent>> = flow {
        emit(Resource.Loading())

        val cachedResponse = valApiDb.agentDao().getAgent(uuid, languageCode = language)?.toAgent()

        if (cachedResponse != null) {
            emit(Resource.Success(cachedResponse))
        } else {
            val response = valorantAPI.getAgentByUuid(language, uuid)
            valApiDb.agentDao().insert(response.toAgentEntity(language))
            emit(Resource.Success(response))
        }
    }
}