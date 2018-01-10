package com.devbridie.wizardsandwarriors.sample

import com.devbridie.wizardsandwarriors.framework.System
import com.devbridie.wizardsandwarriors.sample.attack.AttackModifierEffect
import com.devbridie.wizardsandwarriors.sample.attack.AttackParameters
import com.devbridie.wizardsandwarriors.sample.attack.attackRules
import com.devbridie.wizardsandwarriors.sample.demo.*
import com.devbridie.wizardsandwarriors.sample.models.Combattable
import com.devbridie.wizardsandwarriors.sample.models.Enemy
import com.devbridie.wizardsandwarriors.sample.models.Person
import com.devbridie.wizardsandwarriors.sample.models.Weapon
import com.devbridie.wizardsandwarriors.sample.wield.WieldEffect
import com.devbridie.wizardsandwarriors.sample.wield.WieldParameters
import com.devbridie.wizardsandwarriors.sample.wield.wieldRules


class WizardsAndWarriorsGame(initialState: WizardsAndWarriorsGameState = WizardsAndWarriorsGameState()) : System<WizardsAndWarriorsGameState>(initialState) {
    fun spawnPerson(person: Person) {
        currentState.people += person
    }

    fun spawnEnemy(enemy: Enemy) {
        currentState.enemies += enemy
    }

    fun wield(person: Person, weapon: Weapon): Collection<WieldEffect> {
        return executeCommand(WieldParameters(person, weapon), wieldRules)
    }

    fun attack(attacker: Combattable, attacked: Combattable): Collection<AttackModifierEffect> {
        return executeCommand(AttackParameters(currentState, attacker, attacked), attackRules)
    }

    fun shopSceneWield(person: Person, weapon: Weapon): DisplayWieldEffectEffect {
        val wieldEffect = wield(person, weapon).first()
        return executeCommand(DisplayWieldEffectParameters(WieldParameters(person, weapon), wieldEffect), shopSceneRules).first()
    }

    fun werewolfAttackSceneAttack(attacker: Person, attacked: Enemy): Collection<DisplayAttackResultEffect> {
        val attackEffects = attack(attacker, attacked)
        return executeCommand(DisplayAttackParameters(AttackParameters(currentState, attacker, attacked), attackEffects), werewolfAttackSceneRules)
    }
}