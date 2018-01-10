package com.devbridie.wizardsandwarriors.sample.demo

import com.devbridie.wizardsandwarriors.dsl.rule
import com.devbridie.wizardsandwarriors.dsl.rules
import com.devbridie.wizardsandwarriors.framework.BreakChainEffect
import com.devbridie.wizardsandwarriors.framework.CommandParameters
import com.devbridie.wizardsandwarriors.framework.Effect
import com.devbridie.wizardsandwarriors.sample.models.*
import com.devbridie.wizardsandwarriors.sample.wield.UpdateWeaponWieldEffect
import com.devbridie.wizardsandwarriors.sample.wield.WeaponTooHeavyWieldEffect
import com.devbridie.wizardsandwarriors.sample.wield.WieldEffect
import com.devbridie.wizardsandwarriors.sample.wield.WieldParameters

class DisplayWieldEffectParameters(val wieldParameters: WieldParameters, val wieldEffect: WieldEffect) : CommandParameters()
class DisplayWieldEffectEffect(val message: String) : Effect(), BreakChainEffect

fun shopSceneRule(applicable: DisplayWieldEffectParameters.() -> Boolean,
                  effect: DisplayWieldEffectParameters.() -> DisplayWieldEffectEffect) = rule(applicable, effect)

val shopSceneRules = rules<DisplayWieldEffectParameters, DisplayWieldEffectEffect> {
    // wizard part
    conditional({ wieldParameters.person.type is Wizard }) {
        +shopSceneRule(
                applicable = { wieldEffect is UpdateWeaponWieldEffect && wieldParameters.weapon == Staff },
                effect = { DisplayWieldEffectEffect("${wieldParameters.person} looks satisfied with his new ${wieldParameters.weapon}.") }
        )

        +shopSceneRule(
                applicable = { wieldEffect is UpdateWeaponWieldEffect && wieldParameters.weapon == Dagger },
                effect = { DisplayWieldEffectEffect("${wieldParameters.person} takes the ${wieldParameters.weapon} begrudgingly.") }
        )

        +shopSceneRule(
                applicable = { wieldEffect is WeaponTooHeavyWieldEffect },
                effect = { DisplayWieldEffectEffect("${wieldParameters.person} tries to hold the ${wieldParameters.weapon} up, but is too weak.") }
        )

        +shopSceneRule(
                applicable = always(),
                effect = { DisplayWieldEffectEffect("${wieldParameters.person} doesn't know how to use a ${wieldParameters.weapon}.") }
        )
    }

    conditional({ wieldParameters.person.type is Paladin }) {
        +shopSceneRule(
                applicable = { wieldEffect is UpdateWeaponWieldEffect && wieldParameters.weapon == Sword },
                effect = { DisplayWieldEffectEffect("${wieldParameters.person} takes one of your ${wieldParameters.weapon}s out of desperation!") }
        )

        +shopSceneRule(
                applicable = { wieldEffect is UpdateWeaponWieldEffect && wieldParameters.weapon == HolyMoonSword },
                effect = { DisplayWieldEffectEffect("One of your ${wieldParameters.weapon}s catches ${wieldParameters.person}'s eye! He takes it.") }
        )
    }
}