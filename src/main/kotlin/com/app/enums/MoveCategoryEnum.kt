package com.app.enums

enum class MoveCategoryEnum(val displayName: String) {

    PHYSICAL("Physical"),
    SPECIAL("Special"),
    STATUS("Status");

    companion object {
        fun fromDisplayName(name: String): MoveCategoryEnum? {
            return entries.find { it.displayName.equals(name, ignoreCase = true) }
        }
    }
}