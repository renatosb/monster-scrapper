package com.app.scrapper.functions

import com.app.enums.MonsterEnum

object UrlScrapper {

    fun createUrlsByMonsterName(monsters: List<MonsterEnum>): List<String> {
        return monsters.map {
            val monster = it.displayName.lowercase()
            "https://www.serebii.net/pokedex-champions/$monster/"
        }
    }
}