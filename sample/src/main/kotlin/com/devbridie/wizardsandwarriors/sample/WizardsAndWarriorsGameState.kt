package com.devbridie.wizardsandwarriors.sample

import com.devbridie.wizardsandwarriors.framework.State
import com.devbridie.wizardsandwarriors.sample.models.Enemy
import com.devbridie.wizardsandwarriors.sample.models.Person
import com.devbridie.wizardsandwarriors.sample.models.Time


data class WizardsAndWarriorsGameState(
        var people: Collection<Person> = listOf(),
        var enemies: Collection<Enemy> = listOf(),
        var time: Time = Time.Morning
) : State