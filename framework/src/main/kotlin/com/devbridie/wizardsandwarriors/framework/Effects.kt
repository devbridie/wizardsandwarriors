package com.devbridie.wizardsandwarriors.framework

/**
 * Top-level class for modelling the results of resolving [Rule]s.
 */
abstract class Effect

/**
 * When a [BreakChainEffect] is encountered in a result chain, no more [Rule]s are resolved.
 */
interface BreakChainEffect

/**
 * Models an [Effect] that has an effect on a [System]'s [State].
 */
interface MutateStateEffect<in S: State> {
    fun mutate(state: S)
}