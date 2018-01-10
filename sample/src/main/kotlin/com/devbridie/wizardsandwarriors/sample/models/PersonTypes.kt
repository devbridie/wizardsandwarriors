package com.devbridie.wizardsandwarriors.sample.models


sealed class PersonType(val name: String) {
    override fun toString() = name
}
object Wizard : PersonType("Wizard")
object Warrior : PersonType("Warrior")
object Paladin : PersonType("Paladin")