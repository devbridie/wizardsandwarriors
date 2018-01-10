[com.devbridie.wizardsandwarriors.sample.demo](.)

## Package com.devbridie.wizardsandwarriors.sample.demo

### Types

| Name | Summary |
|---|---|
| [DisplayAttackParameters](-display-attack-parameters/index.md) | `data class DisplayAttackParameters : `[`CommandParameters`](../com.devbridie.wizardsandwarriors.framework/-command-parameters/index.md) |
| [DisplayAttackResultEffect](-display-attack-result-effect/index.md) | `data class DisplayAttackResultEffect : `[`Effect`](../com.devbridie.wizardsandwarriors.framework/-effect/index.md)`, `[`BreakChainEffect`](../com.devbridie.wizardsandwarriors.framework/-break-chain-effect.md) |
| [DisplayWieldEffectEffect](-display-wield-effect-effect/index.md) | `class DisplayWieldEffectEffect : `[`Effect`](../com.devbridie.wizardsandwarriors.framework/-effect/index.md)`, `[`BreakChainEffect`](../com.devbridie.wizardsandwarriors.framework/-break-chain-effect.md) |
| [DisplayWieldEffectParameters](-display-wield-effect-parameters/index.md) | `class DisplayWieldEffectParameters : `[`CommandParameters`](../com.devbridie.wizardsandwarriors.framework/-command-parameters/index.md) |

### Properties

| Name | Summary |
|---|---|
| [shopSceneRules](shop-scene-rules.md) | `val shopSceneRules: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Rule`](../com.devbridie.wizardsandwarriors.framework/-rule/index.md)`<`[`DisplayWieldEffectParameters`](-display-wield-effect-parameters/index.md)`, `[`DisplayWieldEffectEffect`](-display-wield-effect-effect/index.md)`>>` |
| [werewolfAttackSceneRules](werewolf-attack-scene-rules.md) | `val werewolfAttackSceneRules: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Rule`](../com.devbridie.wizardsandwarriors.framework/-rule/index.md)`<`[`DisplayAttackParameters`](-display-attack-parameters/index.md)`, `[`DisplayAttackResultEffect`](-display-attack-result-effect/index.md)`>>` |

### Functions

| Name | Summary |
|---|---|
| [shopSceneRule](shop-scene-rule.md) | `fun shopSceneRule(applicable: `[`DisplayWieldEffectParameters`](-display-wield-effect-parameters/index.md)`.() -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, effect: `[`DisplayWieldEffectParameters`](-display-wield-effect-parameters/index.md)`.() -> `[`DisplayWieldEffectEffect`](-display-wield-effect-effect/index.md)`): `[`Rule`](../com.devbridie.wizardsandwarriors.framework/-rule/index.md)`<`[`DisplayWieldEffectParameters`](-display-wield-effect-parameters/index.md)`, `[`DisplayWieldEffectEffect`](-display-wield-effect-effect/index.md)`>` |
| [werewolfAttackScene](werewolf-attack-scene.md) | `fun werewolfAttackScene(applicable: `[`DisplayAttackParameters`](-display-attack-parameters/index.md)`.() -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, effect: `[`DisplayAttackParameters`](-display-attack-parameters/index.md)`.() -> `[`DisplayAttackResultEffect`](-display-attack-result-effect/index.md)`): `[`Rule`](../com.devbridie.wizardsandwarriors.framework/-rule/index.md)`<`[`DisplayAttackParameters`](-display-attack-parameters/index.md)`, `[`DisplayAttackResultEffect`](-display-attack-result-effect/index.md)`>` |
