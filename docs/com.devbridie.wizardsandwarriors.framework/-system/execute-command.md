[com.devbridie.wizardsandwarriors.framework](../index.md) / [System](index.md) / [executeCommand](.)

# executeCommand

`protected fun <CP : `[`CommandParameters`](../-command-parameters/index.md)`, R : `[`Rule`](../-rule/index.md)`<CP, E>, E : `[`Effect`](../-effect/index.md)`> executeCommand(parameters: CP, rules: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<R>): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<E>`

Executes a given command using [CommandParameters](../-command-parameters/index.md) and a list of [Rule](../-rule/index.md)s.

### Parameters

`parameters` - [CommandParameters](../-command-parameters/index.md) that describe the circumstances of the command.

`rules` - List of [Rule](../-rule/index.md)s that are associated with this command.

**Return**
[Effect](../-effect/index.md)s that the rules produce.

