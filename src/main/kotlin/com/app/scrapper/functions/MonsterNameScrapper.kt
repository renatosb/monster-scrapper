package com.app.scrapper.functions

import com.app.scrapper.response.MonsterNameResponse
import org.jsoup.Jsoup

object MonsterNameScrapper {

    fun getAllSerebiiMonsters(): List<MonsterNameResponse> {
        val url = "https://www.serebii.net/pokemonchampions/pokemon.shtml"
        val doc = Jsoup.connect(url).get()

        val monsters = doc.select("a[href*=/pokedex-champions/]")
            .map { it.text().trim() }
            .filter { it.isNotEmpty() }
            .distinct()

        return monsters.map { MonsterNameResponse(it) }
    }
}