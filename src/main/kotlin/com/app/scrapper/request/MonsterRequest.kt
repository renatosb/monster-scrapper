package com.app.scrapper.request

import com.app.enums.MonsterEnum

data class MonsterRequest(
    val name: MonsterEnum,
    val url: String = "https://www.serebii.net/pokedex-champions/${name.displayName.lowercase()}/",
)
