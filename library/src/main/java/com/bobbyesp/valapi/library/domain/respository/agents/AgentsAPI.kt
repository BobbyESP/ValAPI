package com.bobbyesp.valapi.library.domain.respository.agents

import com.bobbyesp.valapi.library.domain.model.agent.Agents
import com.bobbyesp.valapi.library.util.LanguageCode

interface AgentsAPI {
    suspend fun getAgents(
        language: LanguageCode = LanguageCode.ENGLISH_US,
        isCharacterPlayable: Boolean = true
    ): Agents

    suspend fun getAgentByUuid(
        language: LanguageCode = LanguageCode.ENGLISH_US,
        uuid: String
    ): Agents
}