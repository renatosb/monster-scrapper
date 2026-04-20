package com.app.dto

import com.app.scrapper.response.AbilitiesResponse
import com.app.scrapper.response.MoveResponse
import com.app.scrapper.response.StatsResponse

data class MonsterDTO(
    val name: String,
    val stats: StatsResponse,
    val abilities: AbilitiesResponse,
    val moves: MoveResponse,
)
