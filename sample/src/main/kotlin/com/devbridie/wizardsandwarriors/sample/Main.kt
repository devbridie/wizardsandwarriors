package com.devbridie.wizardsandwarriors.sample

import com.devbridie.wizardsandwarriors.sample.models.*

val game = WizardsAndWarriorsGame()
fun displayMessage(message: String) {
    println(message.capitalize())
}

fun displayEmptyMessage() = println()

fun main(args: Array<String>) {
    val wizard = Person(Wizard).also { game.spawnPerson(it) }.also {
        displayMessage("A $it walks into your weaponry, looking for a weapon.")
    }
    wizardShopScene(wizard)
    displayEmptyMessage()

    val werewolf = Enemy(Werewolf()).also {
        displayMessage("An angry $it enters your Shop!")
    }

    displayMessage("$wizard attacks with his ${wizard.weapon.get()}!")
    game.werewolfAttackSceneAttack(wizard, werewolf).also { it.forEach { displayMessage(it.message) } }

    val paladin = Person(Paladin).also { game.spawnPerson(it) }.also {
        displayMessage("A new person enters your shop! $it follows close behind!")
    }

    game.shopSceneWield(paladin, Sword)

    displayMessage("$paladin attacks with a $Sword!")
    game.werewolfAttackSceneAttack(paladin, werewolf).also { it.forEach { displayMessage(it.message) } }

    game.shopSceneWield(paladin, HolyMoonSword).also { displayMessage(it.message) }
    game.werewolfAttackSceneAttack(paladin, werewolf).also { it.forEach { displayMessage(it.message) } }
    displayMessage("That worked! $werewolf was slain.")

    displayEmptyMessage()

    val werewolfKing = Enemy(type = WerewolfKing()).also {
        displayMessage("An angry $it enters your Shop!")
    }
    game.werewolfAttackSceneAttack(paladin, werewolfKing).also { it.forEach { displayMessage(it.message) } }

    displayMessage("$werewolfKing is injured.")
    displayMessage("$werewolfKing flees!")

    displayEmptyMessage()
    displayMessage("Though your shop is damaged, everybody has survived the ordeal.")
}

fun wizardShopScene(wizard: Person) {
    fun give(person: Person, weapon: Weapon) {
        displayMessage("You give $person a $weapon.")
        game.shopSceneWield(person, weapon).also { displayMessage(it.message) }
    }

    give(wizard, HolyMoonSword)
    give(wizard, Sword)
    give(wizard, Dagger)
    give(wizard, Staff)
}