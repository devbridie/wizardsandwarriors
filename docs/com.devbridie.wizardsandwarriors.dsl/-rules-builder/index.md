[com.devbridie.wizardsandwarriors.dsl](../index.md) / [RulesBuilder](.)

# RulesBuilder

`class RulesBuilder<CP : `[`CommandParameters`](../../com.devbridie.wizardsandwarriors.framework/-command-parameters/index.md)`, E : `[`Effect`](../../com.devbridie.wizardsandwarriors.framework/-effect/index.md)`>`

Builds a list of [Rule](../../com.devbridie.wizardsandwarriors.framework/-rule/index.md)s.

Supports adding rules and nesting rules using the + operator.

**See Also**

[Rule](../../com.devbridie.wizardsandwarriors.framework/-rule/index.md)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `RulesBuilder()`<br>Builds a list of [Rule](../../com.devbridie.wizardsandwarriors.framework/-rule/index.md)s. |

### Functions

| Name | Summary |
|---|---|
| [always](always.md) | `fun always(): `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.() -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [build](build.md) | `fun build(): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Rule`](../../com.devbridie.wizardsandwarriors.framework/-rule/index.md)`<CP, E>>` |
| [conditional](conditional.md) | `fun conditional(condition: CP.() -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, f: RulesBuilder<CP, E>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [unaryPlus](unary-plus.md) | `operator fun `[`Rule`](../../com.devbridie.wizardsandwarriors.framework/-rule/index.md)`<CP, E>.unaryPlus(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`operator fun `[`Collection`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)`<`[`Rule`](../../com.devbridie.wizardsandwarriors.framework/-rule/index.md)`<CP, E>>.unaryPlus(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
