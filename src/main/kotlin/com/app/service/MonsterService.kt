package com.app.service

import com.app.dto.MonsterDTO
import com.app.enums.MonsterEnum
import com.app.model.Monster
import com.app.scrapper.request.SerebiiRequest
import com.app.scrapper.scrapper.AbilitiesScrapper
import com.app.scrapper.scrapper.MovesScrapper
import com.app.scrapper.scrapper.SerebiiScrapper
import com.app.scrapper.scrapper.StatsScrapper

class MonsterService() {

    fun getMonsterByName(name : MonsterEnum): Monster {

       val monster = setupDTO(name)

        return Monster(
            monster.name,
            monster.stats.hp,
            monster.stats.attack,
            monster.stats.defense,
            monster.stats.spAttack,
            monster.stats.spDefense,
            monster.stats.speed,
            monster.abilities.listAbilities,
            monster.moves.listMoves,
        )
    }

    fun setupDTO(name : MonsterEnum) : MonsterDTO {
        val serebiiResponse =
            SerebiiScrapper.getDexTable(SerebiiRequest(name))

        return MonsterDTO(
            serebiiResponse.name,
            StatsScrapper.getStats(serebiiResponse),
            AbilitiesScrapper.getAbilities(serebiiResponse),
            MovesScrapper.getMove(serebiiResponse)
        )
    }
}