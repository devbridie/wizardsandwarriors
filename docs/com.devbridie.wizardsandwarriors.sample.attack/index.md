[com.devbridie.wizardsandwarriors.sample.attack](.)

## Package com.devbridie.wizardsandwarriors.sample.attack

Contains [Rule](../com.devbridie.wizardsandwarriors.framework/-rule/index.md) definitions for defining Attacks.

### Types

| Name | Summary |
|---|---|
| [AttackModifierEffect](-attack-modifier-effect.md) | `sealed class AttackModifierEffect : `[`Effect`](../com.devbridie.wizardsandwarriors.framework/-effect/index.md) |
| [AttackParameters](-attack-parameters/index.md) | `data class AttackParameters : `[`CommandParameters`](../com.devbridie.wizardsandwarriors.framework/-command-parameters/index.md) |
| [AttackPowerModifierModifierEffect](-attack-power-modifier-modifier-effect/index.md) | `abstract class AttackPowerModifierModifierEffect : `[`AttackModifierEffect`](-attack-modifier-effect.md) |
| [AttackWerewolfAtNightAttackModifier](-attack-werewolf-at-night-attack-modifier/index.md) | `class AttackWerewolfAtNightAttackModifier : `[`HitChanceModifierModifierEffect`](-hit-chance-modifier-modifier-effect/index.md) |
| [AttackWerewolfAtNightByHolyAttackModifier](-attack-werewolf-at-night-by-holy-attack-modifier/index.md) | `class AttackWerewolfAtNightByHolyAttackModifier : `[`AttackPowerModifierModifierEffect`](-attack-power-modifier-modifier-effect/index.md) |
| [HitChanceModifierModifierEffect](-hit-chance-modifier-modifier-effect/index.md) | `abstract class HitChanceModifierModifierEffect : `[`AttackModifierEffect`](-attack-modifier-effect.md) |

### Properties

| Name | Summary |
|---|---|
| [attackRules](attack-rules.md) | `val attackRules: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Rule`](../com.devbridie.wizardsandwarriors.framework/-rule/index.md)`<`[`AttackParameters`](-attack-parameters/index.md)`, `[`AttackModifierEffect`](-attack-modifier-effect.md)`>>` |

### Functions

| Name | Summary |
|---|---|
| [attackRule](attack-rule.md) | `fun attackRule(applicable: `[`AttackParameters`](-attack-parameters/index.md)`.() -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, effect: `[`AttackParameters`](-attack-parameters/index.md)`.() -> `[`AttackModifierEffect`](-attack-modifier-effect.md)`): `[`Rule`](../com.devbridie.wizardsandwarriors.framework/-rule/index.md)`<`[`AttackParameters`](-attack-parameters/index.md)`, `[`AttackModifierEffect`](-attack-modifier-effect.md)`>` |
