package com.app.model

import kotlinx.serialization.Serializable

@Serializable
data class Monster(
    val name: String,
    val hp: Int,
    val attack: Int,
    val defense: Int,
    val spAttack: Int,
    val spDefense: Int,
    val speed: Int,
    val abilities: List<Ability>,
    val moves: List<Move>,
){
}