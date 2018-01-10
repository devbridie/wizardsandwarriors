package com.devbridie.wizardsandwarriors.sample.models

import java.util.*


data class Person(
        var type: PersonType,
        var weapon: Optional<Weapon> = Optional.empty()
) : Combattable {
    override fun toString() = "the $type"
}