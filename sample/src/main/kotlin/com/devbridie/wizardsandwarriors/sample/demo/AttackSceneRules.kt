package com.devbridie.wizardsandwarriors.sample.demo

import com.devbridie.wizardsandwarriors.dsl.rule
import com.devbridie.wizardsandwarriors.dsl.rules
import com.devbridie.wizardsandwarriors.framework.BreakChainEffect
import com.devbridie.wizardsandwarriors.framework.CommandParameters
import com.devbridie.wizardsandwarriors.framework.Effect
import com.devbridie.wizardsandwarriors.sample.attack.AttackModifierEffect
import com.devbridie.wizardsandwarriors.sample.attack.AttackParameters
import com.devbridie.wizardsandwarriors.sample.attack.AttackWerewolfAtNightAttackModifier
import com.devbridie.wizardsandwarriors.sample.attack.AttackWerewolfAtNightByHolyAttackModifier
import com.devbridie.wizardsandwarriors.sample.models.HolyMoonSword
import com.devbridie.wizardsandwarriors.sample.models.Person
import java.util.*

data class DisplayAttackParameters(val attackParameters: AttackParameters, val attackEffects: Collection<AttackModifierEffect>) : CommandParameters()
data class DisplayAttackResultEffect(val message: String) : Effect(), BreakChainEffect

fun werewolfAttackScene(applicable: DisplayAttackParameters.() -> Boolean,
                        effect: DisplayAttackParameters.() -> DisplayAttackResultEffect) = rule(applicable, effect)

val werewolfAttackSceneRules = rules<DisplayAttackParameters, DisplayAttackResultEffect> {
    +werewolfAttackScene(
            applicable = { attackEffects.any { it is AttackWerewolfAtNightAttackModifier } },
            effect = { DisplayAttackResultEffect("It's after midnight! ${attackParameters.attacked} gains an elusive bonus.") }
    )

    +werewolfAttackScene(
            applicable = { attackEffects.any { it is AttackWerewolfAtNightByHolyAttackModifier } },
            effect = {
                val attacker = attackParameters.attacker as Person
                DisplayAttackResultEffect("$attacker's ${attacker.weapon.get()} is blessed! It is very effective against ${attackParameters.attacked}.")
            }
    )

    +werewolfAttackScene(
            applicable = { attackParameters.attacker is Person && attackParameters.attacker.weapon == Optional.of(HolyMoonSword) },
            effect = {
                val attacker = attackParameters.attacker as Person
                DisplayAttackResultEffect("$attacker's ${attacker.weapon.get()} is blessed! But ${attackParameters.attacked} overpowers the holy effect!")
            }
    )

    +werewolfAttackScene(
            applicable = always(),
            effect = {
                DisplayAttackResultEffect("${attackParameters.attacker}'s attack is ineffective against ${attackParameters.attacked}!")
            }
    )
}