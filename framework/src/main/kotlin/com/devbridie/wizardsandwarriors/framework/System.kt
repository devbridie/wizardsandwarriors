package com.devbridie.wizardsandwarriors.framework

/**
 * A [System] holds a [State] and knows how to execute commands by resolving a collection of [Rule]s.
 */
abstract class System<S : State>(initialState: S) {
    var currentState = initialState

    /**
     * Executes a given command using [CommandParameters] and a list of [Rule]s.
     *
     * @param parameters [CommandParameters] that describe the circumstances of the command.
     * @param rules List of [Rule]s that are associated with this command.
     * @return [Effect]s that the rules produce.
     */
    protected fun <CP : CommandParameters, R : Rule<CP, E>, E : Effect> executeCommand(parameters: CP, rules: List<R>): List<E> {
        return resolveRules(parameters, rules)
    }

    /**
     * Resolves a rule by getting its [Effect].
     *
     * If the effect is also a [MutateStateEffect], then [currentState] will be updated.
     */
    private fun <P : CommandParameters, E : Effect, R : Rule<P, E>> resolveRule(parameters: P, rule: R): E {
        return rule.getEffect(parameters).also {
            if (it is MutateStateEffect<*>) {
                it as MutateStateEffect<S> // TODO fix dangerous cast
                it.mutate(currentState)
            }
        }
    }

    /**
     * Folds a set of [Rule]s into a list of [Effect]s.
     *
     * Execution of the fold can be interrupted by a [BreakChainEffect].
     */
    private fun <P : CommandParameters, E : Effect, R : Rule<P, E>> resolveRules(parameters: P, rules: List<R>, effectsAccumulator: List<E> = listOf()): List<E> {
        if (rules.isEmpty()) return effectsAccumulator
        val rule = rules.first()
        val otherRules = rules.drop(1)
        return if (rule.isApplicable(parameters)) {
            val effect = resolveRule(parameters, rule)
            val newEffectsAccumulator = effectsAccumulator + effect

            if (effect is BreakChainEffect) newEffectsAccumulator
            else resolveRules(parameters, otherRules, newEffectsAccumulator)
        } else {
            resolveRules(parameters, otherRules, effectsAccumulator)
        }
    }
}