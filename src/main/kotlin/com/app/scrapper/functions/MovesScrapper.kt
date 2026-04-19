package com.app.scrapper.functions

import org.jsoup.nodes.Element

object MovesScrapper {

    fun getMoveBySerebiiDexTable(dexTables: List<Element>, monsterName: String): Any{
        val movesTable = dexTables.firstOrNull { table ->
            table.select("tr").any { tr ->
                tr.text().contains("Standard Moves", ignoreCase = true)
            }
        } ?: throw IllegalStateException("Stats table não encontrada: $monsterName")

        return movesTable
    }
}