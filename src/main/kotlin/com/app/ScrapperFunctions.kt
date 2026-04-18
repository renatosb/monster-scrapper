package com.app

import com.app.model.Monster
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element

class ScrapperFunctions {

    fun getMonster(urls: List<String>): List<Monster> {

        return urls.map {
            getMonsterBySerebiiDexTables(
                getDexTablesBySerebiiUrl(it)
            )
        }
    }

    fun getAllMonsters(){
        val url = "https://www.serebii.net/pokemonchampions/pokemon.shtml"
        val doc = Jsoup.connect(url).get()

        val pokemons = doc.select("a[href*=/pokedex-champions/]")
            .map { it.text().trim() }
            .filter { it.isNotEmpty() }
            .distinct()

        pokemons.forEach { println(it) }
    }

    private fun getMonsterBySerebiiDexTables(dexTables: List<Element>): Monster {

        val name = dexTables[1]
            .select("tr")[1]
            .select("td")[0]
            .text()

        val tdBaseStats = when (dexTables.size) {
            7 -> dexTables[6].select("tr")[2]
            9 -> dexTables[8].select("tr")[2]
            13 -> dexTables[7].select("tr")[2]
            12 -> dexTables[6].select("tr")[2]
            17 -> dexTables[6].select("tr")[2]
            else -> throw IllegalStateException("Erro em: $name")
        }

        val tds = tdBaseStats.select("td")

        return Monster(
            name,
            tds[1].text().toInt(),
            tds[2].text().toInt(),
            tds[3].text().toInt(),
            tds[4].text().toInt(),
            tds[5].text().toInt(),
            tds[6].text().toInt(),
        )
    }

    private fun getDexTablesBySerebiiUrl(url: String): List<Element> {
        val doc: Document = Jsoup.connect(url).get()
        val dexTables: List<Element> = doc.select("table.dextable")

        return dexTables
    }
}