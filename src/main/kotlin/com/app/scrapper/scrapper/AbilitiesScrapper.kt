package com.app.scrapper.scrapper

import com.app.model.Ability
import com.app.scrapper.response.AbilitiesResponse
import com.app.scrapper.response.SerebiiResponse
import org.jsoup.nodes.TextNode
import kotlin.collections.chunked

object AbilitiesScrapper {

    fun getAbilities(serebiiResponse: SerebiiResponse): AbilitiesResponse {

        val abilityTable = serebiiResponse.dexTables.firstOrNull { table ->
            table.select("tr").any { tr ->
                tr.text().contains("Abilities", ignoreCase = true)
            }
        } ?: throw IllegalStateException("Ability table não encontrada: ${serebiiResponse.name}")

        val abilitiesTr = abilityTable.select("tr")
        val abilitiesTd = abilitiesTr.select("td")
        val filterAbilitiesTd = abilitiesTd.select("td")

        val abilitiesName = abilitiesTr.select("b").drop(1).map { it.text().trim() }.distinct()
        val abilitiesDescription =
            filterAbilitiesTd[1]
            .textNodes()
            .mapNotNull { element ->
                val t = element.text().trim()
                t.takeIf { it.isNotEmpty() }
            }

        return AbilitiesResponse(
            abilitiesName.zip(abilitiesDescription) { name, description ->

                Ability(
                    name,
                    description.replace(": ", ""),
                )
            }
        )
    }
}