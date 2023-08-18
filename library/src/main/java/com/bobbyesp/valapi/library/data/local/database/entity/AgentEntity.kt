package com.bobbyesp.valapi.library.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bobbyesp.valapi.library.domain.model.agent.Ability
import com.bobbyesp.valapi.library.domain.model.agent.Agent
import com.bobbyesp.valapi.library.domain.model.agent.Role
import com.bobbyesp.valapi.library.domain.model.agent.VoiceLine

@Entity(tableName = "agents")
data class AgentEntity(
    @PrimaryKey val uuid: String,
    val abilities: List<Ability> = listOf(),
    val assetPath: String = "",
    val background: String? = null,
    val backgroundGradientColors: List<String> = listOf(),
    val bustPortrait: String? = null,
    val characterTags: List<String>? = null,
    val description: String = "",
    val developerName: String = "",
    val displayIcon: String = "",
    val displayIconSmall: String = "",
    val displayName: String = "",
    val fullPortrait: String? = null,
    val fullPortraitV2: String? = null,
    val isAvailableForTest: Boolean = false,
    val isBaseContent: Boolean = false,
    val isFullPortraitRightFacing: Boolean = false,
    val isPlayableCharacter: Boolean = false,
    val killfeedPortrait: String = "",
    val role: Role? = null,
    val voiceLine: VoiceLine = VoiceLine(),
    val timestamp: Long = System.currentTimeMillis()
) {
    companion object {
        fun fromAgent(agent: Agent): AgentEntity {
            return AgentEntity(
                uuid = agent.uuid,
                displayName = agent.displayName,
                description = agent.description,
                developerName = agent.developerName,
                displayIcon = agent.displayIcon,
                displayIconSmall = agent.displayIconSmall,
                bustPortrait = agent.bustPortrait,
                fullPortrait = agent.fullPortrait,
                killfeedPortrait = agent.killfeedPortrait,
                assetPath = agent.assetPath,
                isFullPortraitRightFacing = agent.isFullPortraitRightFacing,
                isPlayableCharacter = agent.isPlayableCharacter,
                isAvailableForTest = agent.isAvailableForTest,
                role = agent.role,
                abilities = agent.abilities
            )
        }

        fun AgentEntity.toAgent(): Agent {
            return Agent(
                uuid = this.uuid,
                displayName = this.displayName,
                description = this.description,
                developerName = this.developerName,
                displayIcon = this.displayIcon,
                displayIconSmall = this.displayIconSmall,
                bustPortrait = this.bustPortrait,
                fullPortrait = this.fullPortrait,
                killfeedPortrait = this.killfeedPortrait,
                assetPath = this.assetPath,
                isFullPortraitRightFacing = this.isFullPortraitRightFacing,
                isPlayableCharacter = this.isPlayableCharacter,
                isAvailableForTest = this.isAvailableForTest,
                role = this.role,
                abilities = this.abilities
            )
        }
    }
}
