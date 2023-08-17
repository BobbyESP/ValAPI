package com.bobbyesp.valapi.library.domain.model.weapons


import kotlinx.serialization.Serializable

@Serializable
data class Weapons(
    val `data`: List<Weapon> = listOf(),
    val status: Int = 0
)