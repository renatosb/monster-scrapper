package com.app

import com.app.enums.MonsterEnum

fun main() {
    val scrapperFunctions = ScrapperFunctions()

    val urls: List<String> = MonsterEnum.entries.map {
        val monster = it.displayName.lowercase()
        "https://www.serebii.net/pokedex-champions/$monster/"
    }

    val result = scrapperFunctions.getMonster(urls)
    println(result)
}
