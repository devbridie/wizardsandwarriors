# wizardsandwarriors
[Documentation](https://devbridie.github.io/wizardsandwarriors/docs/)

[Eric Lippert](https://ericlippert.com/) wrote an [article series called Wizards and Warriors](https://ericlippert.com/2015/04/27/wizards-and-warriors-part-one/)
introducing a problem in Object Orientated Programming that seems simple at first glance but quickly reveals itself to be
a complicated software engineering. I found the article very thought-provoking.
It inspired me to write this related work and code that implements the rule system as proposed by Eric, as well as a simple demonstration that uses this system in a simple text adventure with two scenes.

## Introduction

*If you've already read [Eric Lippert's Wizards and Warriors](https://ericlippert.com/2015/04/27/wizards-and-warriors-part-one/)
(15 min.), you can probably skip to Implementation. Though I will attempt to summarize my main takeaways
from the article below, I would still recommend that you read the original.*

It starts with a simple set of objects and is-a relationships (using a fantasy RPG genre game as an illustration).

* A wizard is a kind of player.
* A warrior is a kind of player.
* A staff is a kind of weapon.
* A sword is a kind of weapon.
* A player has a weapon.

Intuitively, you might think of the following code:

```kotlin
sealed class Weapon
class Staff : Weapon()
class Sword : Weapon()

sealed class Player
class Wizard : Player()
class Warrior : Player()
```

The relations listed above have been captured. Job well done.

However, the following constraints are added to the system:

* A Warrior can only use a Sword.
* A Wizard can only use a Staff.

Eric then shows possible attempts at modeling such a system, of which I will summarize some.

### 'Solution' with Subtyping
```kotlin
sealed class Weapon
class Staff : Weapon()
class Sword : Weapon()

sealed class Player(open var weapon: Weapon)
class Wizard(override var weapon: Staff) : Player(weapon)
class Warrior(override var weapon: Sword) : Player(weapon)
```

Though this might seem sound, the Kotlin compiler will throw the following exception:
`Kotlin: Type of 'weapon' doesn't match the type of the overridden var-property 'public open var weapon: Weapon defined in Player'`.

If the compiler did not throw this exception, then a `Wizard` casted to a `Player` can be assigned
a `Sword`, while the class definition for `Wizard` disallows this.

### 'Solution' with Generics
```kotlin
sealed class Weapon
class Staff : Weapon()
class Sword : Weapon()

sealed class Player<T: Weapon>(open var weapon: T)
class Wizard : Player<Staff>(weapon)
class Warrior : Player<Sword>(weapon)
```

Great! The compiler will protect us from assigning a `Sword` to a `Wizard`.
But this does not scale: what if we were to introduce class-specific armor?
And what if our specifications add that everybody can also wield `Dagger`s?

### Placement of Concerns

Eric then shows us a related problem: Suppose the problems above were solved in an ideal manner.
Our game is extended with the ability to attack monsters given the following classes:

```kotlin
sealed class Player
class Warrior : Player()

sealed class Monster
class Werewolf : Monster()
```

[To quote](https://ericlippert.com/2015/05/04/wizards-and-warriors-part-three/):
"Where exactly does the code go that determines whether the Warrior successfully hits the Werewolf?"
"Somewhere there is a method, let’s call it Attack; what does that method look like?"

Or, more generally: *where should such logic belong?* Eric justly argues against the use of a
[Visitor Pattern](https://github.com/dbacinski/Design-Patterns-In-Kotlin/blob/master/src/main/kotlin/Visitor.kt)
in [his article](https://ericlippert.com/2015/05/04/wizards-and-warriors-part-three/): the notation is verbose and error-prone.
Also, it does not scale as the complexity of the system grows: one would have to continue to add parameters.

## Rules
In [Part 5](https://ericlippert.com/2015/05/11/wizards-and-warriors-part-five/), Eric proposes a paradigm shift:
the business logic of this game can be modelled by a set of Rules.
This allows our examples to be expressed:

* Warriors cannot wield Staffs.
* Wizards cannot wield Swords.
* Everybody can wield Daggers.

What if a new weapon type is added? Then add new rules that represent the underlying business logic.

Furthermore, the nature of exceptions are used to support the paradigm shift: they are used to handle errors and other exceptional events.
If a Wizard tries to wield a Sword, should that result in an Exception?

Eric proposes that the actual business logic is the following:

* The core objects of the system are *users, commands, state,* and *rules*.
* A user provides a sequence of *commands*.
  * This models a request to perform an action in the system, possibly changing state.
* These commands are evaluated in the context of a series of rules, possibly carrying parameters.
  * Some are applicable to the current command (is logic concerning Daggers relevant to a Warrior wielding a Staff?)
* These evaluations produce one or more *effects*.
  * Examples of such an effect are 'do nothing', mutate state, display a message.
  * Certain effects can be composited.

As I was curious to see how such a system could be implemented and used, I set out to create a framework utilizing these ideas.

## Implementation
I started with a simple goal in mind: implement the example of Wizards and Warriors wielding Staffs, Swords, and Daggers.

This would start with a generic representation of a Rule, Effect, State, and System.
A Rule would be applicable in some contexts, called Parameters in context of a Command, and would result in some Effect.
A System would be the glue of the framework, knowing which Rules are involved in this system, handling commands and interpreting the obtained Effects.

Then, work began on the WieldRules, using the [Inform7](http://inform7.com/) rules as in the article as a starting point of what I would want the API to become.
However, I wanted to create rules that are type-safe and use a fluent DSL to express them. Kotlin is apt for this using their [Type-Safe Builders](https://kotlinlang.org/docs/reference/type-safe-builders.html).

I separated rules that represented definitions into Classes. An example of this is the following:

```Inform7
A wizard is a kind of person.
A warrior is a kind of person.
```

would become:

```kotlin
data class Person(var type: PersonType)

sealed class PersonType(val name: String)
object Wizard : PersonType("Wizard")
object Warrior : PersonType("Warrior")
```

With the game models defined, work could begin on the rules. The notion of wielding a weapon concerns two instances:
The wielder and the weapon being wielded. Then, abstractly, the applicability of this rule `Wielding a sword: if the wielder is not a warrior, it is too heavy.`
could be expressed as `weapon is Sword && wielder.type !is Warrior`. The effect of this rule would be `WeaponTooHeavyEffect`.
This leads to the composition of the rule expressed in the following DSL:

```kotlin
val wieldRules = rules<WieldParameters, WieldEffect> {
    +wieldRule(
            applicable = { weapon is Sword && person.type !is Warrior },
            effect = { WeaponTooHeavyWieldEffect }
    )
}
```

And the normal case of wielding a weapon:

```kotlin
val wieldRules = rules<WieldParameters, WieldEffect> {
    +wieldRule(
            applicable = always(),
            effect = { UpdateWeaponWieldEffect(this) }
    )
}
```

where `this` refers to the incoming WieldParameters. This effect leads to a mutation of game state (MutateStateEffect).

However, resolution of these rules was not as simple as thought. Some Rules should be final in their chain;
if one rule dictates that a weapon may not be wielded, the default rule (wield the weapon) should not be resolved.
This led to the introduction of the BreakChainEffect.

Creative thinking led to the narrative shown in the main method, demonstrating the basics of the rule system.
The text displayed is a result of composition of effects: `WieldEffect -> DisplayWieldEffectEffect`.
This allows the business logic (A warrior cannot wield a staff) to remain context-independent.

With this, the initial goal was completed.

### Extension
#### Becoming a user
Suppose I were a user of the framework: what features would I want? In context of game development, I immediately
thought of expansion packs: What if `Paladin`s were added to the game? How could this new class and their related logic
be added to the system without disturbing existing logic?

By allowing rulebooks to be composed, this can be incorporated into the system.
Also, it quickly became clear that repetition of applicability should somehow be avoided: I created a
`conditional` group that applies a given `isApplicable` to a group of Rules.