[com.devbridie.wizardsandwarriors.framework](../index.md) / [Rule](.)

# Rule

`interface Rule<in CP : `[`CommandParameters`](../-command-parameters/index.md)`, out E : `[`Effect`](../-effect/index.md)`>`

Represents a piece of business logic in a [System](../-system/index.md).

Uses [CP](#) to determine if this rule [isApplicable](is-applicable.md) and what the [Effect](../-effect/index.md) result should be.

### Functions

| Name | Summary |
|---|---|
| [getEffect](get-effect.md) | `abstract fun getEffect(parameters: CP): E` |
| [isApplicable](is-applicable.md) | `abstract fun isApplicable(parameters: CP): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
