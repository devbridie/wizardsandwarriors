[com.devbridie.wizardsandwarriors.framework](../index.md) / [Effect](.)

# Effect

`abstract class Effect`

Top-level class for modelling the results of resolving [Rule](../-rule/index.md)s.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Effect()`<br>Top-level class for modelling the results of resolving [Rule](../-rule/index.md)s. |

### Inheritors

| Name | Summary |
|---|---|
| [AttackModifierEffect](../../com.devbridie.wizardsandwarriors.sample.attack/-attack-modifier-effect.md) | `sealed class AttackModifierEffect : Effect` |
| [DisplayAttackResultEffect](../../com.devbridie.wizardsandwarriors.sample.demo/-display-attack-result-effect/index.md) | `data class DisplayAttackResultEffect : Effect, `[`BreakChainEffect`](../-break-chain-effect.md) |
| [DisplayWieldEffectEffect](../../com.devbridie.wizardsandwarriors.sample.demo/-display-wield-effect-effect/index.md) | `class DisplayWieldEffectEffect : Effect, `[`BreakChainEffect`](../-break-chain-effect.md) |
| [WieldEffect](../../com.devbridie.wizardsandwarriors.sample.wield/-wield-effect.md) | `sealed class WieldEffect : Effect` |
