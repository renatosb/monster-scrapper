package com.app.enums

import kotlin.math.E

enum class MoveCategoryEnum(val displayName: String) {

    PHYSICAL("Physical"),
    SPECIAL("Special"),
    STATUS("Status");

    companion object {
        fun fromDisplayName(name: String): MoveCategoryEnum? {
            return when (name) {
                "Other" -> STATUS
                else -> entries.find {
                    it.displayName.equals(name, ignoreCase = true)
                }
            }
        }
    }
}