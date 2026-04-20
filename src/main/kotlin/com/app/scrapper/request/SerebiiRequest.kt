package com.app.scrapper.request

import com.app.enums.MonsterEnum

data class SerebiiRequest(
    val name: MonsterEnum,
    val url: String = "https://www.serebii.net/pokedex-champions/${name.displayName.lowercase()}/",
)
