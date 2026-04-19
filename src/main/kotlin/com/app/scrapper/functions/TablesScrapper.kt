package com.app.scrapper.functions

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element

object TablesScrapper {

    private fun getDexTablesBySerebiiUrl(url: String): List<Element> {
        val doc: Document = Jsoup.connect(url).get()
        val dexTables: List<Element> = doc.select("table.dextable")

        return dexTables
    }
}