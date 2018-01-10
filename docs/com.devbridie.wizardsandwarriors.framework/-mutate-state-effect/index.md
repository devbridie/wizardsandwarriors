[com.devbridie.wizardsandwarriors.framework](../index.md) / [MutateStateEffect](.)

# MutateStateEffect

`interface MutateStateEffect<in S : `[`State`](../-state.md)`>`

Models an [Effect](../-effect/index.md) that has an effect on a [System](../-system/index.md)'s [State](../-state.md).

### Functions

| Name | Summary |
|---|---|
| [mutate](mutate.md) | `abstract fun mutate(state: S): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [UpdateWeaponWieldEffect](../../com.devbridie.wizardsandwarriors.sample.wield/-update-weapon-wield-effect/index.md) | `class UpdateWeaponWieldEffect : `[`WieldEffect`](../../com.devbridie.wizardsandwarriors.sample.wield/-wield-effect.md)`, `[`BreakChainEffect`](../-break-chain-effect.md)`, MutateStateEffect<`[`WizardsAndWarriorsGameState`](../../com.devbridie.wizardsandwarriors.sample/-wizards-and-warriors-game-state/index.md)`>` |
