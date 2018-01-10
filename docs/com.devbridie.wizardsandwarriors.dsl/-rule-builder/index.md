[com.devbridie.wizardsandwarriors.dsl](../index.md) / [RuleBuilder](.)

# RuleBuilder

`class RuleBuilder<in CP : `[`CommandParameters`](../../com.devbridie.wizardsandwarriors.framework/-command-parameters/index.md)`, out E : `[`Effect`](../../com.devbridie.wizardsandwarriors.framework/-effect/index.md)`>`

Builds a [Rule](../../com.devbridie.wizardsandwarriors.framework/-rule/index.md).

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `RuleBuilder(applicable: CP.() -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, effect: CP.() -> E)`<br>Builds a [Rule](../../com.devbridie.wizardsandwarriors.framework/-rule/index.md). |

### Properties

| Name | Summary |
|---|---|
| [applicable](applicable.md) | `val applicable: CP.() -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [effect](effect.md) | `val effect: CP.() -> E` |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(): `[`Rule`](../../com.devbridie.wizardsandwarriors.framework/-rule/index.md)`<CP, E>` |
