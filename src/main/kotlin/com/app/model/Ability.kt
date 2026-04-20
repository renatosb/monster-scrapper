package com.app.model

import kotlinx.serialization.Serializable

@Serializable
data class Ability(
    val name: String,
    val description: String,
)
