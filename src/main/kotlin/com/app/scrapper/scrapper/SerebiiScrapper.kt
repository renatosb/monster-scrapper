package com.app.scrapper.scrapper

import com.app.scrapper.request.SerebiiRequest
import com.app.scrapper.response.AvailableMonsterResponse
import com.app.scrapper.response.SerebiiResponse
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element

object SerebiiScrapper {

    fun getDexTable(serebiiRequest: SerebiiRequest): SerebiiResponse {
        val doc: Document = Jsoup.connect(serebiiRequest.url).get()
        val dexTables: List<Element> = doc.select("table.dextable")

        return SerebiiResponse(
            serebiiRequest.name.displayName,
            dexTables
        )
    }

    fun getAvailableMonsters(): List<AvailableMonsterResponse> {
        val url = "https://www.serebii.net/pokemonchampions/pokemon.shtml"
        val doc = Jsoup.connect(url).get()

        val monsters = doc.select("a[href*=/pokedex-champions/]")
            .map { it.text().trim() }
            .filter { it.isNotEmpty() }
            .distinct()

        return monsters.map { AvailableMonsterResponse(it) }
    }
}