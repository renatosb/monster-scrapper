package com.app.scrapper.scrapper

import com.app.scrapper.response.SerebiiResponse
import com.app.scrapper.response.StatsResponse
import org.jsoup.nodes.Element

object StatsScrapper {

    fun getStats(serebiiResponse: SerebiiResponse): StatsResponse {

        val statsTable = serebiiResponse.dexTables.firstOrNull { table ->
            table.select("tr").any { tr ->
                tr.text().contains("Stats -", ignoreCase = true)
            }
        } ?: throw IllegalStateException("Stats table não encontrada: ${serebiiResponse.name}")

        val tdBaseStats = statsTable.select("tr")[2]
        val tds = tdBaseStats.select("td")

        return StatsResponse(
            tds[1].text().toInt(),
            tds[2].text().toInt(),
            tds[3].text().toInt(),
            tds[4].text().toInt(),
            tds[5].text().toInt(),
            tds[6].text().toInt(),
        )
    }
}