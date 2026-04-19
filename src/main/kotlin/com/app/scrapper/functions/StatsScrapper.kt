package com.app.scrapper.functions

import com.app.scrapper.response.StatsDTO
import org.jsoup.nodes.Element

object StatsScrapper {

    fun getStatsBySerebiiDexTable(dexTables: List<Element>): StatsDTO {

        val statsTable = dexTables.firstOrNull { table ->
            table.select("tr").any { tr ->
                tr.text().contains("Stats -", ignoreCase = true)
            }
        } ?: throw IllegalStateException("Stats table não encontrada")

        val tdBaseStats = statsTable.select("tr")[2]
        val tds = tdBaseStats.select("td")

        return StatsDTO(
            tds[1].text().toInt(),
            tds[2].text().toInt(),
            tds[3].text().toInt(),
            tds[4].text().toInt(),
            tds[5].text().toInt(),
            tds[6].text().toInt(),
        )
    }
}