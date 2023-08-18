package com.bobbyesp.valapi.library.domain.respository.agents

import com.bobbyesp.valapi.library.domain.model.agent.Agent
import com.bobbyesp.valapi.library.domain.model.agent.Agents
import com.bobbyesp.valapi.library.util.LanguageCode
import com.bobbyesp.valapi.library.util.data.Resource
import kotlinx.coroutines.flow.Flow

interface AgentsAPI {
    suspend fun getAgents(
        language: LanguageCode = LanguageCode.ENGLISH_US,
        isCharacterPlayable: Boolean = true
    ): Flow<Resource<List<Agent>>>

    suspend fun getAgentByUuid(
        language: LanguageCode = LanguageCode.ENGLISH_US,
        uuid: String
    ): Flow<Resource<Agent>>
}