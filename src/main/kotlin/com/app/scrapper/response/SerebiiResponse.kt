package com.app.scrapper.response

import org.jsoup.nodes.Element

data class SerebiiResponse(
    val name: String,
    val dexTables: List<Element>,
)
