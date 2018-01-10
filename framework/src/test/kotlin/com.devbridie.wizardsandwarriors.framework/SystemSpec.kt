package com.devbridie.wizardsandwarriors.framework

import io.kotlintest.matchers.beOfType
import io.kotlintest.matchers.haveSize
import io.kotlintest.matchers.should
import io.kotlintest.matchers.shouldBe
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object SystemSpec : Spek({
    on("execute command with applicable and non-applicable rules") {
        val notApplicableRule = object : Rule<EmptyTestCommandParameters, NoOpEffect1> {
            override fun isApplicable(parameters: EmptyTestCommandParameters) = false
            override fun getEffect(parameters: EmptyTestCommandParameters) = NoOpEffect1
        }

        val applicableRule = object : Rule<EmptyTestCommandParameters, NoOpEffect2> {
            override fun isApplicable(parameters: EmptyTestCommandParameters) = true
            override fun getEffect(parameters: EmptyTestCommandParameters) = NoOpEffect2
        }

        val rules = listOf(notApplicableRule, applicableRule, applicableRule)
        val system = object : System<EmptyGameState>(EmptyGameState) {
            fun test() = executeCommand(EmptyTestCommandParameters, rules)
        }
        val effects = system.test()
        it("should resolve only applicable rules") {
            effects should haveSize(2)
            effects shouldBe listOf(NoOpEffect2, NoOpEffect2)
        }
    }

    on("execute command with a ChainBreakEffect") {
        val breakRule = object : Rule<CommandParameters, Effect> {
            override fun isApplicable(parameters: CommandParameters) = true
            override fun getEffect(parameters: CommandParameters) = TestBreakChainEffect
        }
        val rules = listOf(NoOperationRule, breakRule, NoOperationRule)
        val system = object : System<State>(EmptyGameState) {
            fun test() = executeCommand(EmptyTestCommandParameters, rules)
        }

        val effects = system.test()
        it("should abort the chain when encountering a ChainBreakEffect") {
            effects should haveSize(2)
            effects shouldBe listOf(NoOpEffect, TestBreakChainEffect)
        }
    }

    on("execute command with MutateStateEffect") {
        class NumberState(var number: Int = 5) : State
        class AddNumberParameters(val number: Int) : CommandParameters()
        class AddNumberEffect(val number: Int) : Effect(), MutateStateEffect<NumberState> {
            override fun mutate(state: NumberState) {
                state.number += number
            }
        }

        val mutateRule = object : Rule<AddNumberParameters, AddNumberEffect> {
            override fun isApplicable(parameters: AddNumberParameters) = true
            override fun getEffect(parameters: AddNumberParameters) = AddNumberEffect(parameters.number)
        }

        val rules = listOf(NoOperationRule, mutateRule, mutateRule)
        val system = object : System<NumberState>(NumberState()) {
            fun addNumber(number: Int) = executeCommand(AddNumberParameters(number), rules)
        }
        val effects = system.addNumber(3)
        it("should have the correct effects") {
            effects should haveSize(3)
            effects[0] should beOfType<NoOpEffect>()
            effects[1] should beOfType<AddNumberEffect>()
            effects[2] should beOfType<AddNumberEffect>()
        }

        it("should mutate state") {
            system.currentState.number shouldBe 11
        }
    }
})