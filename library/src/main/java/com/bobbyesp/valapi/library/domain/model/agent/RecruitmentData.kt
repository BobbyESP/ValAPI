package com.bobbyesp.valapi.library.domain.model.agent

import kotlinx.serialization.Serializable

@Serializable
data class RecruitmentData(
    val counterId: String = "",
    val endDate: String = "",
    val levelVpCostOverride: Int = 0,
    val milestoneId: String = "",
    val milestoneThreshold: Int = 0,
    val startDate: String = "",
    val useLevelVpCostOverride: Boolean = false
)
