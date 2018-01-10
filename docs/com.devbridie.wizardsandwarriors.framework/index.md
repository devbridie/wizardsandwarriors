[com.devbridie.wizardsandwarriors.framework](.)

## Package com.devbridie.wizardsandwarriors.framework

Contains the backbone for the system proposed in [Wizards and Warriors part 5](https://ericlippert.com/2015/05/11/wizards-and-warriors-part-five/).

### Types

| Name | Summary |
|---|---|
| [BreakChainEffect](-break-chain-effect.md) | `interface BreakChainEffect`<br>When a [BreakChainEffect](-break-chain-effect.md) is encountered in a result chain, no more [Rule](-rule/index.md)s are resolved. |
| [CommandParameters](-command-parameters/index.md) | `abstract class CommandParameters`<br>Represents the circumstances in which a command is executed. |
| [Effect](-effect/index.md) | `abstract class Effect`<br>Top-level class for modelling the results of resolving [Rule](-rule/index.md)s. |
| [MutateStateEffect](-mutate-state-effect/index.md) | `interface MutateStateEffect<in S : `[`State`](-state.md)`>`<br>Models an [Effect](-effect/index.md) that has an effect on a [System](-system/index.md)'s [State](-state.md). |
| [Rule](-rule/index.md) | `interface Rule<in CP : `[`CommandParameters`](-command-parameters/index.md)`, out E : `[`Effect`](-effect/index.md)`>`<br>Represents a piece of business logic in a [System](-system/index.md). |
| [State](-state.md) | `interface State`<br>Represents the internal state of a given [System](-system/index.md). |
| [System](-system/index.md) | `abstract class System<S : `[`State`](-state.md)`>`<br>A [System](-system/index.md) holds a [State](-state.md) and knows how to execute commands by resolving a collection of [Rule](-rule/index.md)s. |
