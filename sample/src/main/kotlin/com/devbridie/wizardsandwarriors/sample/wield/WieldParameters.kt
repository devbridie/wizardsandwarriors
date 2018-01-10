package com.devbridie.wizardsandwarriors.sample.wield

import com.devbridie.wizardsandwarriors.framework.CommandParameters
import com.devbridie.wizardsandwarriors.sample.models.Person
import com.devbridie.wizardsandwarriors.sample.models.Weapon

data class WieldParameters(val person: Person, val weapon: Weapon) : CommandParameters()
