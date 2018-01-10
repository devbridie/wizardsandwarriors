package com.devbridie.wizardsandwarriors.sample.attack

import com.devbridie.wizardsandwarriors.framework.Effect

sealed class AttackModifierEffect : Effect()
abstract class HitChanceModifierModifierEffect(val percent: Double) : AttackModifierEffect()
class AttackWerewolfAtNightAttackModifier : HitChanceModifierModifierEffect(20.0)

abstract class AttackPowerModifierModifierEffect(val attackPower: Double) : AttackModifierEffect()
class AttackWerewolfAtNightByHolyAttackModifier : AttackPowerModifierModifierEffect(8.0)