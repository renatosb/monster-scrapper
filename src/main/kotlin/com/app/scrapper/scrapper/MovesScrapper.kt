package com.app.scrapper.scrapper

import com.app.enums.MoveCategoryEnum
import com.app.enums.TypeEnum
import com.app.model.Move
import com.app.scrapper.response.MoveResponse
import com.app.scrapper.response.SerebiiResponse

object MovesScrapper {

    fun getMove(serebiiResponse: SerebiiResponse): MoveResponse {

        val movesTable = serebiiResponse.dexTables.firstOrNull { table ->
            table.select("tr").any { tr ->
                tr.text().contains("Standard Moves", ignoreCase = true)
            }
        } ?: throw IllegalStateException("Stats table não encontrada: ${serebiiResponse.name}")

        val movesTr = movesTable.select("tr")
        val movesTd = movesTr.select("td").drop(1)

        return MoveResponse(
            movesTd.chunked(8).map {

                val moveName = it[0].text().trim()

                val type = it[1].select("img").attr("alt")
                    .replace("$moveName -", "")
                    .replace("-", "")
                    .replace("type", "")
                    .trim()
                print("")
                val typeEnum = TypeEnum.fromDisplayName(type)!!


                val moveCategory = it[2].select("img").attr("alt")
                    .replace(moveName, "")
                    .replace(":", "")
                    .replace("Move", "")
                    .trim()
                print("")
                val moveCategoryEnum = MoveCategoryEnum.fromDisplayName(moveCategory)!!

                Move(
                    moveName,
                    typeEnum,
                    moveCategoryEnum,
                    safeConvertToInt(it[3].text()),
                    safeConvertToInt(it[4].text()),
                    safeConvertToInt(it[5].text()),
                    safeConvertToInt(it[6].text()),
                    it[7].text().trim(),
                )
            }
        )
    }

    private fun safeConvertToInt(text: String): Int {
        return when (text) {
            "--" -> 0
            "??" -> 0
            else -> text.toInt()
        }
    }
}