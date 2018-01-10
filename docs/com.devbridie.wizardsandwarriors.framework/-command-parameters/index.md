[com.devbridie.wizardsandwarriors.framework](../index.md) / [CommandParameters](.)

# CommandParameters

`abstract class CommandParameters`

Represents the circumstances in which a command is executed.

Rules can use instances of this class to determine applicability.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `CommandParameters()`<br>Represents the circumstances in which a command is executed. |

### Inheritors

| Name | Summary |
|---|---|
| [AttackParameters](../../com.devbridie.wizardsandwarriors.sample.attack/-attack-parameters/index.md) | `data class AttackParameters : CommandParameters` |
| [DisplayAttackParameters](../../com.devbridie.wizardsandwarriors.sample.demo/-display-attack-parameters/index.md) | `data class DisplayAttackParameters : CommandParameters` |
| [DisplayWieldEffectParameters](../../com.devbridie.wizardsandwarriors.sample.demo/-display-wield-effect-parameters/index.md) | `class DisplayWieldEffectParameters : CommandParameters` |
| [WieldParameters](../../com.devbridie.wizardsandwarriors.sample.wield/-wield-parameters/index.md) | `data class WieldParameters : CommandParameters` |
