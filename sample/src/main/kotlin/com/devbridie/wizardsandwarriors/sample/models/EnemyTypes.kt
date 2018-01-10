package com.devbridie.wizardsandwarriors.sample.models


sealed class EnemyType(val name: String) {
    override fun toString() = name
}
open class Werewolf(name: String = "Werewolf") : EnemyType(name)
class WerewolfKing : Werewolf("Werewolf King")