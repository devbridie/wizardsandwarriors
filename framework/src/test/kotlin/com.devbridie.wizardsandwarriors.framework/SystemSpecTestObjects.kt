package com.devbridie.wizardsandwarriors.framework


object NoOpEffect1 : Effect()
object NoOpEffect2 : Effect()

object EmptyGameState : State

object EmptyTestCommandParameters : CommandParameters()

object NoOpEffect : Effect()
object TestBreakChainEffect : BreakChainEffect, Effect()

object NoOperationRule : Rule<CommandParameters, Effect> {
    override fun isApplicable(parameters: CommandParameters) = true
    override fun getEffect(parameters: CommandParameters) = NoOpEffect
}