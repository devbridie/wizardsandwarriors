package com.devbridie.wizardsandwarriors.sample.models


sealed class Weapon(val name: String) {
    override fun toString() = name
}
object Sword : Weapon("Sword")
object Dagger : Weapon("Dagger")
object Staff : Weapon("Staff")
object HolyMoonSword : Weapon("Holy Moon Sword")