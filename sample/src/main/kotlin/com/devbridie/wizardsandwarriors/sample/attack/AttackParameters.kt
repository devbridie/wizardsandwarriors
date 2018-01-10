package com.devbridie.wizardsandwarriors.sample.attack

import com.devbridie.wizardsandwarriors.framework.CommandParameters
import com.devbridie.wizardsandwarriors.sample.WizardsAndWarriorsGameState
import com.devbridie.wizardsandwarriors.sample.models.Combattable

data class AttackParameters(
        val gameState: WizardsAndWarriorsGameState,
        val attacker: Combattable,
        val attacked: Combattable
) : CommandParameters()
