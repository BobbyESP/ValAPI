package com.bobbyesp.valapi.library.data.remote.specific

import com.bobbyesp.valapi.library.data.local.database.ValAPILibraryDb
import com.bobbyesp.valapi.library.data.local.database.entity.AgentEntity.Companion.toAgent
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
): AgentsAPI {
    override suspend fun getAgents(
        language: LanguageCode,
        isCharacterPlayable: Boolean
    ): Flow<Resource<List<Agent>>> = flow {
        emit(Resource.Loading())

        val cachedResponse = valApiDb.agentDao().getAll().map {
            it.toAgent()
        }

        if (cachedResponse.isNotEmpty()) {
            emit(Resource.Success(cachedResponse))
        } else {
//            val response = valorantAPI.getAgents(language, isCharacterPlayable)
//            if (response is Resource.Success) {
//                valApiDb.agentDao().insertAll(response.data)
//            }
//            emit(response)
        }

    }

    override suspend fun getAgentByUuid(
        language: LanguageCode,
        uuid: String
    ): Flow<Resource<Agent>> {
        TODO("Not yet implemented")
    }
}