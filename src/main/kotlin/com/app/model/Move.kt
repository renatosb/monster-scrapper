package com.app.model

import com.app.enums.MoveCategoryEnum
import com.app.enums.TypeEnum
import jdk.jfr.Description
import kotlinx.serialization.Serializable

@Serializable
data class Move(
    val attackName :String,
    val type: TypeEnum,
    val category: MoveCategoryEnum,
    val damage: Int,
    val accuracy: Int,
    val pp: Int,
    val effectRate: Int,
    val description: String,
)
