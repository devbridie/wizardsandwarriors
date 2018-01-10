[com.devbridie.wizardsandwarriors.sample.models](.)

## Package com.devbridie.wizardsandwarriors.sample.models

Contains classes used in [Wizards and Warriors part 5](https://ericlippert.com/2015/05/11/wizards-and-warriors-part-five/).

### Types

| Name | Summary |
|---|---|
| [Combattable](-combattable.md) | `interface Combattable` |
| [Dagger](-dagger.md) | `object Dagger : `[`Weapon`](-weapon/index.md) |
| [Enemy](-enemy/index.md) | `data class Enemy : `[`Combattable`](-combattable.md) |
| [EnemyType](-enemy-type/index.md) | `sealed class EnemyType` |
| [HolyMoonSword](-holy-moon-sword.md) | `object HolyMoonSword : `[`Weapon`](-weapon/index.md) |
| [Paladin](-paladin.md) | `object Paladin : `[`PersonType`](-person-type/index.md) |
| [Person](-person/index.md) | `data class Person : `[`Combattable`](-combattable.md) |
| [PersonType](-person-type/index.md) | `sealed class PersonType` |
| [Staff](-staff.md) | `object Staff : `[`Weapon`](-weapon/index.md) |
| [Sword](-sword.md) | `object Sword : `[`Weapon`](-weapon/index.md) |
| [Time](-time/index.md) | `enum class Time` |
| [Warrior](-warrior.md) | `object Warrior : `[`PersonType`](-person-type/index.md) |
| [Weapon](-weapon/index.md) | `sealed class Weapon` |
| [Werewolf](-werewolf/index.md) | `open class Werewolf : `[`EnemyType`](-enemy-type/index.md) |
| [WerewolfKing](-werewolf-king/index.md) | `class WerewolfKing : `[`Werewolf`](-werewolf/index.md) |
| [Wizard](-wizard.md) | `object Wizard : `[`PersonType`](-person-type/index.md) |
