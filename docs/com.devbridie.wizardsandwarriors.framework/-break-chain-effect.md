[com.devbridie.wizardsandwarriors.framework](index.md) / [BreakChainEffect](.)

# BreakChainEffect

`interface BreakChainEffect`

When a BreakChainEffect is encountered in a result chain, no more [Rule](-rule/index.md)s are resolved.

### Inheritors

| Name | Summary |
|---|---|
| [DeclineWieldEffect](../com.devbridie.wizardsandwarriors.sample.wield/-decline-wield-effect.md) | `sealed class DeclineWieldEffect : `[`WieldEffect`](../com.devbridie.wizardsandwarriors.sample.wield/-wield-effect.md)`, BreakChainEffect` |
| [DisplayAttackResultEffect](../com.devbridie.wizardsandwarriors.sample.demo/-display-attack-result-effect/index.md) | `data class DisplayAttackResultEffect : `[`Effect`](-effect/index.md)`, BreakChainEffect` |
| [DisplayWieldEffectEffect](../com.devbridie.wizardsandwarriors.sample.demo/-display-wield-effect-effect/index.md) | `class DisplayWieldEffectEffect : `[`Effect`](-effect/index.md)`, BreakChainEffect` |
| [UpdateWeaponWieldEffect](../com.devbridie.wizardsandwarriors.sample.wield/-update-weapon-wield-effect/index.md) | `class UpdateWeaponWieldEffect : `[`WieldEffect`](../com.devbridie.wizardsandwarriors.sample.wield/-wield-effect.md)`, BreakChainEffect, `[`MutateStateEffect`](-mutate-state-effect/index.md)`<`[`WizardsAndWarriorsGameState`](../com.devbridie.wizardsandwarriors.sample/-wizards-and-warriors-game-state/index.md)`>` |
