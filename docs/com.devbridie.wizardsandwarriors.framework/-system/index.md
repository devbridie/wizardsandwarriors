[com.devbridie.wizardsandwarriors.framework](../index.md) / [System](.)

# System

`abstract class System<S : `[`State`](../-state.md)`>`

A System holds a [State](../-state.md) and knows how to execute commands by resolving a collection of [Rule](../-rule/index.md)s.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `System(initialState: S)`<br>A System holds a [State](../-state.md) and knows how to execute commands by resolving a collection of [Rule](../-rule/index.md)s. |

### Properties

| Name | Summary |
|---|---|
| [currentState](current-state.md) | `var currentState: S` |

### Functions

| Name | Summary |
|---|---|
| [executeCommand](execute-command.md) | `fun <CP : `[`CommandParameters`](../-command-parameters/index.md)`, R : `[`Rule`](../-rule/index.md)`<CP, E>, E : `[`Effect`](../-effect/index.md)`> executeCommand(parameters: CP, rules: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<R>): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<E>`<br>Executes a given command using [CommandParameters](../-command-parameters/index.md) and a list of [Rule](../-rule/index.md)s. |

### Inheritors

| Name | Summary |
|---|---|
| [WizardsAndWarriorsGame](../../com.devbridie.wizardsandwarriors.sample/-wizards-and-warriors-game/index.md) | `class WizardsAndWarriorsGame : System<`[`WizardsAndWarriorsGameState`](../../com.devbridie.wizardsandwarriors.sample/-wizards-and-warriors-game-state/index.md)`>` |
