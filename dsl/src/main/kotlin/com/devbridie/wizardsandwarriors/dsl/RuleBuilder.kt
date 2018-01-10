package com.devbridie.wizardsandwarriors.dsl

import com.devbridie.wizardsandwarriors.framework.CommandParameters
import com.devbridie.wizardsandwarriors.framework.Effect
import com.devbridie.wizardsandwarriors.framework.Rule

/**
 * Builds a [Rule].
 */
@RuleBuilderMarker
class RuleBuilder<in CP : CommandParameters, out E : Effect>(
        val applicable: (CP.() -> Boolean),
        val effect: (CP.() -> E)
) {
    fun build() = object : Rule<CP, E> {
        override fun isApplicable(parameters: CP) = this@RuleBuilder.applicable(parameters)
        override fun getEffect(parameters: CP) = this@RuleBuilder.effect(parameters)
    }
}

/**
 * Builds a [Rule] using a DSL.
 * @param applicable a function that specifies if this rule can be used given these parameters. [CP] is given as receiver.
 * @param effect function that specifies what the effect is of applying this [Rule]. [CP] is given as receiver.
 * @see Rule
 */
fun <CP: CommandParameters, E: Effect> rule(applicable: CP.() -> Boolean,
                                            effect: CP.() -> E): Rule<CP, E> {
    return RuleBuilder(applicable, effect).build()
}