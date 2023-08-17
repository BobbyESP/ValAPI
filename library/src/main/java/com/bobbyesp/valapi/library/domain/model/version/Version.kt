package com.bobbyesp.valapi.library.domain.model.version


import kotlinx.serialization.Serializable

@Serializable
data class Version(
    val branch: String = "",
    val buildDate: String = "",
    val buildVersion: String = "",
    val engineVersion: String = "",
    val manifestId: String = "",
    val riotClientBuild: String = "",
    val riotClientVersion: String = "",
    val version: String = ""
)