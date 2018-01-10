package com.devbridie.wizardsandwarriors.dsl

import com.devbridie.wizardsandwarriors.framework.CommandParameters
import com.devbridie.wizardsandwarriors.framework.Effect
import io.kotlintest.matchers.shouldBe
import io.kotlintest.matchers.shouldThrow
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on


object RuleBuilderSpec : Spek({
    val applicable: CommandParameters.() -> Boolean = { true }
    val effect: CommandParameters.() -> Effect = { throw RuntimeException("Expected") }
    val parameters = object : CommandParameters() {}
    on("build") {
        val rule = RuleBuilder(applicable = applicable, effect = effect).build()
        it("should return the given rule applicable") {
            rule.isApplicable(parameters) shouldBe true
        }

        it("should return the given rule effect") {
            val exception = shouldThrow<RuntimeException> {
                rule.getEffect(parameters)
            }
            exception.message shouldBe "Expected"
        }
    }

    on("dsl") {
        val dslRule = rule(applicable = applicable, effect = effect)
        it("should return the given rule applicable") {
            dslRule.isApplicable(parameters) shouldBe true
        }

        it("should return the given rule effect") {
            val exception = shouldThrow<RuntimeException> {
                dslRule.getEffect(parameters)
            }
            exception.message shouldBe "Expected"
        }
    }

})