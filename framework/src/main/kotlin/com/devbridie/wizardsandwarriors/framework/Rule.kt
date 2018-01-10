package com.devbridie.wizardsandwarriors.framework

/**
 * Represents a piece of business logic in a [System].
 *
 * Uses [CP] to determine if this rule [isApplicable] and what the [Effect] result should be.
 */
interface Rule<in CP : CommandParameters, out E : Effect> {
    /**
     * @return true if this rule should be applied given [parameters].
     */
    fun isApplicable(parameters: CP): Boolean

    /**
     * @return a subclass of [Effect] when this rule is applied.
     * @see BreakChainEffect
     * @see MutateStateEffect
     */
    fun getEffect(parameters: CP): E
}