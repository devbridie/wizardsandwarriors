package com.devbridie.wizardsandwarriors.sample.models

import java.util.*


data class Person(
        var type: PersonType,
        var weapon: Optional<Weapon> = Optional.empty(),
        val id: Int = Counter.id++
) : Combattable {
    companion object Counter {
        var id = 0
    }

    override fun toString() = "the $type"
}