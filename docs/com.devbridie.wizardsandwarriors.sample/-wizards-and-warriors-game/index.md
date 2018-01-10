[com.devbridie.wizardsandwarriors.sample](../index.md) / [WizardsAndWarriorsGame](.)

# WizardsAndWarriorsGame

`class WizardsAndWarriorsGame : `[`System`](../../com.devbridie.wizardsandwarriors.framework/-system/index.md)`<`[`WizardsAndWarriorsGameState`](../-wizards-and-warriors-game-state/index.md)`>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `WizardsAndWarriorsGame(initialState: `[`WizardsAndWarriorsGameState`](../-wizards-and-warriors-game-state/index.md)` = WizardsAndWarriorsGameState())` |

### Inherited Properties

| Name | Summary |
|---|---|
| [currentState](../../com.devbridie.wizardsandwarriors.framework/-system/current-state.md) | `var currentState: S` |

### Functions

| Name | Summary |
|---|---|
| [attack](attack.md) | `fun attack(attacker: `[`Combattable`](../../com.devbridie.wizardsandwarriors.sample.models/-combattable.md)`, attacked: `[`Combattable`](../../com.devbridie.wizardsandwarriors.sample.models/-combattable.md)`): `[`Collection`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)`<`[`AttackModifierEffect`](../../com.devbridie.wizardsandwarriors.sample.attack/-attack-modifier-effect.md)`>` |
| [shopSceneWield](shop-scene-wield.md) | `fun shopSceneWield(person: `[`Person`](../../com.devbridie.wizardsandwarriors.sample.models/-person/index.md)`, weapon: `[`Weapon`](../../com.devbridie.wizardsandwarriors.sample.models/-weapon/index.md)`): `[`DisplayWieldEffectEffect`](../../com.devbridie.wizardsandwarriors.sample.demo/-display-wield-effect-effect/index.md) |
| [spawnEnemy](spawn-enemy.md) | `fun spawnEnemy(enemy: `[`Enemy`](../../com.devbridie.wizardsandwarriors.sample.models/-enemy/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [spawnPerson](spawn-person.md) | `fun spawnPerson(person: `[`Person`](../../com.devbridie.wizardsandwarriors.sample.models/-person/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [werewolfAttackSceneAttack](werewolf-attack-scene-attack.md) | `fun werewolfAttackSceneAttack(attacker: `[`Person`](../../com.devbridie.wizardsandwarriors.sample.models/-person/index.md)`, attacked: `[`Enemy`](../../com.devbridie.wizardsandwarriors.sample.models/-enemy/index.md)`): `[`Collection`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)`<`[`DisplayAttackResultEffect`](../../com.devbridie.wizardsandwarriors.sample.demo/-display-attack-result-effect/index.md)`>` |
| [wield](wield.md) | `fun wield(person: `[`Person`](../../com.devbridie.wizardsandwarriors.sample.models/-person/index.md)`, weapon: `[`Weapon`](../../com.devbridie.wizardsandwarriors.sample.models/-weapon/index.md)`): `[`Collection`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)`<`[`WieldEffect`](../../com.devbridie.wizardsandwarriors.sample.wield/-wield-effect.md)`>` |

### Inherited Functions

| Name | Summary |
|---|---|
| [executeCommand](../../com.devbridie.wizardsandwarriors.framework/-system/execute-command.md) | `fun <CP : `[`CommandParameters`](../../com.devbridie.wizardsandwarriors.framework/-command-parameters/index.md)`, R : `[`Rule`](../../com.devbridie.wizardsandwarriors.framework/-rule/index.md)`<CP, E>, E : `[`Effect`](../../com.devbridie.wizardsandwarriors.framework/-effect/index.md)`> executeCommand(parameters: CP, rules: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<R>): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<E>`<br>Executes a given command using [CommandParameters](../../com.devbridie.wizardsandwarriors.framework/-command-parameters/index.md) and a list of [Rule](../../com.devbridie.wizardsandwarriors.framework/-rule/index.md)s. |
