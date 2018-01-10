package com.devbridie.wizardsandwarriors.sample.wield

import com.devbridie.wizardsandwarriors.framework.BreakChainEffect
import com.devbridie.wizardsandwarriors.framework.Effect
import com.devbridie.wizardsandwarriors.framework.MutateStateEffect
import com.devbridie.wizardsandwarriors.sample.WizardsAndWarriorsGameState
import java.util.*

sealed class WieldEffect : Effect()
sealed class DeclineWieldEffect() : WieldEffect(), BreakChainEffect

object WeaponTooHeavyWieldEffect : DeclineWieldEffect()
object WeaponTooMagicalWieldEffect : DeclineWieldEffect()
object NotAPaladinWieldEffect : DeclineWieldEffect()

class UpdateWeaponWieldEffect(val parameters: WieldParameters) : WieldEffect(), BreakChainEffect, MutateStateEffect<WizardsAndWarriorsGameState> {
    override fun mutate(state: WizardsAndWarriorsGameState) {
        with(parameters) {
            parameters.person.weapon = Optional.of(weapon)
        }
    }
}