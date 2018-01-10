package com.devbridie.wizardsandwarriors.sample.attack

import com.devbridie.wizardsandwarriors.dsl.rule
import com.devbridie.wizardsandwarriors.dsl.rules
import com.devbridie.wizardsandwarriors.sample.models.*
import java.util.*


fun attackRule(applicable: AttackParameters.() -> Boolean,
               effect: AttackParameters.() -> AttackModifierEffect) = rule(applicable, effect)

val attackRules = rules<AttackParameters, AttackModifierEffect> {
    conditional({ attacked is Enemy && attacked.type is Werewolf }) {
        +attackRule(
                applicable = { gameState.time == Time.Night },
                effect = { AttackWerewolfAtNightAttackModifier() }
        )

        +attackRule(
                applicable = {
                    attacked is Enemy && attacked.type !is WerewolfKing &&
                            attacker is Person && attacker.type == Paladin && attacker.weapon == Optional.of(HolyMoonSword)
                },
                effect = { AttackWerewolfAtNightByHolyAttackModifier() }
        )
    }
}