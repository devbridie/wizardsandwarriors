[com.devbridie.wizardsandwarriors.sample.wield](.)

## Package com.devbridie.wizardsandwarriors.sample.wield

Contains [Rule](../com.devbridie.wizardsandwarriors.framework/-rule/index.md) definitions for defining Wields.

### Types

| Name | Summary |
|---|---|
| [DeclineWieldEffect](-decline-wield-effect.md) | `sealed class DeclineWieldEffect : `[`WieldEffect`](-wield-effect.md)`, `[`BreakChainEffect`](../com.devbridie.wizardsandwarriors.framework/-break-chain-effect.md) |
| [NotAPaladinWieldEffect](-not-a-paladin-wield-effect.md) | `object NotAPaladinWieldEffect : `[`DeclineWieldEffect`](-decline-wield-effect.md) |
| [UpdateWeaponWieldEffect](-update-weapon-wield-effect/index.md) | `class UpdateWeaponWieldEffect : `[`WieldEffect`](-wield-effect.md)`, `[`BreakChainEffect`](../com.devbridie.wizardsandwarriors.framework/-break-chain-effect.md)`, `[`MutateStateEffect`](../com.devbridie.wizardsandwarriors.framework/-mutate-state-effect/index.md)`<`[`WizardsAndWarriorsGameState`](../com.devbridie.wizardsandwarriors.sample/-wizards-and-warriors-game-state/index.md)`>` |
| [WeaponTooHeavyWieldEffect](-weapon-too-heavy-wield-effect.md) | `object WeaponTooHeavyWieldEffect : `[`DeclineWieldEffect`](-decline-wield-effect.md) |
| [WeaponTooMagicalWieldEffect](-weapon-too-magical-wield-effect.md) | `object WeaponTooMagicalWieldEffect : `[`DeclineWieldEffect`](-decline-wield-effect.md) |
| [WieldEffect](-wield-effect.md) | `sealed class WieldEffect : `[`Effect`](../com.devbridie.wizardsandwarriors.framework/-effect/index.md) |
| [WieldParameters](-wield-parameters/index.md) | `data class WieldParameters : `[`CommandParameters`](../com.devbridie.wizardsandwarriors.framework/-command-parameters/index.md) |

### Properties

| Name | Summary |
|---|---|
| [paladinExpansionWieldRules](paladin-expansion-wield-rules.md) | `val paladinExpansionWieldRules: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Rule`](../com.devbridie.wizardsandwarriors.framework/-rule/index.md)`<`[`WieldParameters`](-wield-parameters/index.md)`, `[`WieldEffect`](-wield-effect.md)`>>` |
| [wieldRules](wield-rules.md) | `val wieldRules: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Rule`](../com.devbridie.wizardsandwarriors.framework/-rule/index.md)`<`[`WieldParameters`](-wield-parameters/index.md)`, `[`WieldEffect`](-wield-effect.md)`>>` |

### Functions

| Name | Summary |
|---|---|
| [wieldRule](wield-rule.md) | `fun wieldRule(applicable: `[`WieldParameters`](-wield-parameters/index.md)`.() -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, effect: `[`WieldParameters`](-wield-parameters/index.md)`.() -> `[`WieldEffect`](-wield-effect.md)`): `[`Rule`](../com.devbridie.wizardsandwarriors.framework/-rule/index.md)`<`[`WieldParameters`](-wield-parameters/index.md)`, `[`WieldEffect`](-wield-effect.md)`>` |
