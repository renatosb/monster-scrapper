package com.app.service

import com.app.model.Monster
import com.app.scrapper.functions.StatsScrapper.getMonsterBySerebiiDexTables
import org.jsoup.nodes.Element

class MonsterService {

    fun getMonster(urls: List<String>): List<Monster> {

        Monster(

        )
    }

    private fun getMonsterBySerebiiDexTables(dexTables: List<Element>): Monster {



        return Monster(
            name,
            tds[1].text().toInt(),
            tds[2].text().toInt(),
            tds[3].text().toInt(),
            tds[4].text().toInt(),
            tds[5].text().toInt(),
            tds[6].text().toInt(),
            listOf(),
            listOf()
        )
    }
}