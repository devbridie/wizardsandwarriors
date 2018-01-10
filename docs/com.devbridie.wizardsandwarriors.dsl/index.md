[com.devbridie.wizardsandwarriors.dsl](.)

## Package com.devbridie.wizardsandwarriors.dsl

Contains helpers for building [Rule](../com.devbridie.wizardsandwarriors.framework/-rule/index.md)s by DSL.

### Types

| Name | Summary |
|---|---|
| [RuleBuilder](-rule-builder/index.md) | `class RuleBuilder<in CP : `[`CommandParameters`](../com.devbridie.wizardsandwarriors.framework/-command-parameters/index.md)`, out E : `[`Effect`](../com.devbridie.wizardsandwarriors.framework/-effect/index.md)`>`<br>Builds a [Rule](../com.devbridie.wizardsandwarriors.framework/-rule/index.md). |
| [RulesBuilder](-rules-builder/index.md) | `class RulesBuilder<CP : `[`CommandParameters`](../com.devbridie.wizardsandwarriors.framework/-command-parameters/index.md)`, E : `[`Effect`](../com.devbridie.wizardsandwarriors.framework/-effect/index.md)`>`<br>Builds a list of [Rule](../com.devbridie.wizardsandwarriors.framework/-rule/index.md)s. |

### Annotations

| Name | Summary |
|---|---|
| [RuleBuilderMarker](-rule-builder-marker/index.md) | `annotation class RuleBuilderMarker` |

### Functions

| Name | Summary |
|---|---|
| [rule](rule.md) | `fun <CP : `[`CommandParameters`](../com.devbridie.wizardsandwarriors.framework/-command-parameters/index.md)`, E : `[`Effect`](../com.devbridie.wizardsandwarriors.framework/-effect/index.md)`> rule(applicable: CP.() -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, effect: CP.() -> E): `[`Rule`](../com.devbridie.wizardsandwarriors.framework/-rule/index.md)`<CP, E>`<br>Builds a [Rule](../com.devbridie.wizardsandwarriors.framework/-rule/index.md) using a DSL. |
| [rules](rules.md) | `fun <CP : `[`CommandParameters`](../com.devbridie.wizardsandwarriors.framework/-command-parameters/index.md)`, E : `[`Effect`](../com.devbridie.wizardsandwarriors.framework/-effect/index.md)`> rules(f: `[`RulesBuilder`](-rules-builder/index.md)`<CP, E>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Rule`](../com.devbridie.wizardsandwarriors.framework/-rule/index.md)`<CP, E>>`<br>Builds a list of [Rule](../com.devbridie.wizardsandwarriors.framework/-rule/index.md)s using a DSL. |
