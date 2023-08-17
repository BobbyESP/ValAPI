package com.bobbyesp.valapi.library.domain.model.agent


import kotlinx.serialization.Serializable

@Serializable
data class Agent(
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
    val uuid: String = "",
    val voiceLine: VoiceLine = VoiceLine()
)