package com.devbridie.wizardsandwarriors.dsl

import com.devbridie.wizardsandwarriors.framework.CommandParameters
import com.devbridie.wizardsandwarriors.framework.Effect
import com.devbridie.wizardsandwarriors.framework.Rule

/**
 * Builds a list of [Rule]s.
 *
 * Supports adding rules and nesting rules using the + operator.
 * @see Rule
 */
@RuleBuilderMarker
class RulesBuilder<CP : CommandParameters, E: Effect> {
    private val buildList = mutableListOf<Rule<CP,E>>()
    operator fun Rule<CP,E>.unaryPlus() {
        buildList.add(this)
    }

    operator fun Collection<Rule<CP,E>>.unaryPlus() {
        buildList.addAll(this)
    }

    fun conditional(condition: CP.() -> Boolean, f: RulesBuilder<CP, E>.() -> Unit) {
        val innerBuilder = RulesBuilder<CP, E>().apply(f)
        val withAddedCondition = innerBuilder.buildList.map { innerRule ->
            object : Rule<CP, E> {
            override fun isApplicable(parameters: CP): Boolean {
                return condition(parameters) && innerRule.isApplicable(parameters)
            }

            override fun getEffect(parameters: CP): E {
                return innerRule.getEffect(parameters)
            }

        }}
        buildList.addAll(withAddedCondition)
    }

    fun build(): List<Rule<CP, E>> = buildList.toList()

    fun always(): Any.() -> Boolean {
        return { true }
    }
}

/**
 * Builds a list of [Rule]s using a DSL.
 * @see Rule
 */
fun <CP : CommandParameters, E: Effect> rules(f: RulesBuilder<CP, E>.() -> Unit): List<Rule<CP, E>> {
    return RulesBuilder<CP, E>().apply(f).build()
}