package com.devbridie.wizardsandwarriors.sample.wield

import com.devbridie.wizardsandwarriors.dsl.rule
import com.devbridie.wizardsandwarriors.dsl.rules
import com.devbridie.wizardsandwarriors.sample.models.*

fun wieldRule(applicable: WieldParameters.() -> Boolean,
              effect: WieldParameters.() -> WieldEffect) = rule(applicable, effect)

val paladinExpansionWieldRules = rules<WieldParameters, WieldEffect>{
    +wieldRule(
            applicable = { (weapon is HolyMoonSword || weapon is Sword) && person.type is Paladin },
            effect = { UpdateWeaponWieldEffect(this) }
    )

    +wieldRule(
            applicable = { weapon is HolyMoonSword && person.type !is Paladin },
            effect = { NotAPaladinWieldEffect }
    )
}

val wieldRules = rules<WieldParameters, WieldEffect> {
    + paladinExpansionWieldRules

    +wieldRule(
            applicable = { weapon is Sword && person.type !is Warrior },
            effect = { WeaponTooHeavyWieldEffect }
    )

    +wieldRule(
            applicable = { weapon is Staff && person.type !is Wizard },
            effect = { WeaponTooMagicalWieldEffect }
    )

    +wieldRule(
            applicable = always(),
            effect = { UpdateWeaponWieldEffect(this) }
    )
}