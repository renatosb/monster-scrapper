package com.app.enums

enum class NatureEnum(
    val displayName: String,
    val increasedStatEnum: StatEnum?,
    val decreasedStatEnum: StatEnum?
) {

    HARDY("Hardy", null, null),
    LONELY("Lonely", StatEnum.ATTACK, StatEnum.DEFENSE),
    BRAVE("Brave", StatEnum.ATTACK, StatEnum.SPEED),
    ADAMANT("Adamant", StatEnum.ATTACK, StatEnum.SP_ATTACK),
    NAUGHTY("Naughty", StatEnum.ATTACK, StatEnum.SP_DEFENSE),

    BOLD("Bold", StatEnum.DEFENSE, StatEnum.ATTACK),
    DOCILE("Docile", null, null),
    RELAXED("Relaxed", StatEnum.DEFENSE, StatEnum.SPEED),
    IMPISH("Impish", StatEnum.DEFENSE, StatEnum.SP_ATTACK),
    LAX("Lax", StatEnum.DEFENSE, StatEnum.SP_DEFENSE),

    TIMID("Timid", StatEnum.SPEED, StatEnum.ATTACK),
    HASTY("Hasty", StatEnum.SPEED, StatEnum.DEFENSE),
    SERIOUS("Serious", null, null),
    JOLLY("Jolly", StatEnum.SPEED, StatEnum.SP_ATTACK),
    NAIVE("Naive", StatEnum.SPEED, StatEnum.SP_DEFENSE),

    MODEST("Modest", StatEnum.SP_ATTACK, StatEnum.ATTACK),
    MILD("Mild", StatEnum.SP_ATTACK, StatEnum.DEFENSE),
    QUIET("Quiet", StatEnum.SP_ATTACK, StatEnum.SPEED),
    BASHFUL("Bashful", null, null),
    RASH("Rash", StatEnum.SP_ATTACK, StatEnum.SP_DEFENSE),

    CALM("Calm", StatEnum.SP_DEFENSE, StatEnum.ATTACK),
    GENTLE("Gentle", StatEnum.SP_DEFENSE, StatEnum.DEFENSE),
    SASSY("Sassy", StatEnum.SP_DEFENSE, StatEnum.SPEED),
    CAREFUL("Careful", StatEnum.SP_DEFENSE, StatEnum.SP_ATTACK),
    QUIRKY("Quirky", null, null);

    companion object {
        fun fromDisplayName(name: String): NatureEnum? {
            return entries.find { it.displayName.equals(name, ignoreCase = true) }
        }
    }
}