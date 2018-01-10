# wizardsandwarriors
[Documentation](https://devbridie.github.io/wizardsandwarriors/docs/)

[Eric Lippert](https://ericlippert.com/) wrote an [article series called Wizards and Warriors](https://ericlippert.com/2015/04/27/wizards-and-warriors-part-one/)
introducing a problem in Object Orientated Programming that seems simple at first glance but quickly reveals itself to be
a complicated software engineering. I found the article very thought-provoking.
It inspired me to write this related work and code that [implements the rule system](https://devbridie.github.io/wizardsandwarriors/docs/com.devbridie.wizardsandwarriors.framework/) as proposed by Eric, as well as a [simple demonstration that uses this system](https://github.com/devbridie/wizardsandwarriors/blob/master/sample/src/main/kotlin/com/devbridie/wizardsandwarriors/sample/Main.kt) in a simple text adventure with two scenes. You can find the completed code [on GitHub](https://github.com/devbridie/wizardsandwarriors).

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
I started with a simple goal in mind: implement the example game of Wizards and Warriors wielding Staffs, Swords, and Daggers. Using the [Inform7](http://inform7.com/) rules as in [part 5](https://ericlippert.com/2015/05/11/wizards-and-warriors-part-five/) as a starting point of what I would want the API to become.

### Core Representation
The representation of the functionality that should be implemented would contain the following nouns: *Rule*, *Parameter*, *Effect*, *State*, and *System*.

* A *Rule* is a small chunk of business logic. A rule is given some *Parameter*s and results in some *Effect*.
* A *System* is the glue of the framework. It knows which *Rule*s exist, it handles commands, and it handles the resulting Effects. It also maintains a given *State*, dispatching mutations to this state where needed.

These resulted in [the rule framework](https://github.com/devbridie/wizardsandwarriors/tree/master/framework/src/main/kotlin/com/devbridie/wizardsandwarriors/framework).

### Representing State
I separated rules that represented definitions into classes. An example of this is the following:

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

In context of the game, these object definitions can be found in [sample objects](https://github.com/devbridie/wizardsandwarriors/tree/master/sample/src/main/kotlin/com/devbridie/wizardsandwarriors/sample/models).

### Creating a WieldRule
A concrete implementation of such a Rule is a [`WieldRule`](https://github.com/devbridie/wizardsandwarriors/blob/master/sample/src/main/kotlin/com/devbridie/wizardsandwarriors/sample/wield/WieldRulebook.kt). It will express what the effects of a command for a '`Person` to wield a `Weapon`' should be.

The notion of wielding a weapon concerns two instances: The wielder and the weapon being wielded. 
Then, abstractly, the applicability of the rule `When wielding a sword: if the wielder is not a warrior, it is too heavy.`
could be expressed as `weapon is Sword && wielder.type !is Warrior`. The effect of this rule would be `WeaponTooHeavyWieldEffect`.
This leads to the composition of the rule expressed in the following DSL [Type-Safe Builders](https://kotlinlang.org/docs/reference/type-safe-builders.html).:

```kotlin
wieldRule(
    applicable = { weapon is Sword && person.type !is Warrior },
    effect = { WeaponTooHeavyWieldEffect }
)
```

And the 'normal' case of wielding a weapon:

```kotlin
wieldRule(
    applicable = always(),
    effect = { UpdateWeaponWieldEffect(this) }
)
```

where `this` refers to the incoming `WieldParameter`s. The resolution of this Rule leads to an Effect that represents a `Wizard` wielding a `Staff`.

### Rule Resolution
However, resolution of these rules was not as simple as thought. Some Rules should be final in their chain;
if one rule dictates that a `Wizard` may not wield a `Sword`, the default rule (wield the weapon) should not be resolved.
This led to the introduction of the `BreakChainEffect`, a tag that determines that no further rules should be resolved.

[Rule resolution](https://github.com/devbridie/wizardsandwarriors/blob/90ffa9d4a9c12b3f4cfbdd2f7349db90f6b8ff4e/framework/src/main/kotlin/com/devbridie/wizardsandwarriors/framework/System.kt#L39) is done with using a modified functional reduce, mapping applicable Rules to Effects. When a `BreakChainEffect` is encountered, the reduce is stopped.

### Stengths of the Implementation
The flexibility of the framework allows for arbitrarily complex rules and effects. 

Effects can be composed by creating Rules that take an Effect as Parameter. An example of this is displaying the result of a wield command: `WieldEffect -> DisplayWieldEffectEffect`. In the context of a certain scene, a wield might result in a diffrerent display text. This allows the business logic (A warrior cannot wield a staff) to remain context-independent.

Rule composition can be created by creating new rules that combine other rules. An example of this is a conditional group that makes rules more specific:

```kotlin
conditional({ wieldParameters.person.type is Wizard }) {
	+shopSceneRule(
		applicable = { wieldEffect is UpdateWeaponWieldEffect && wieldParameters.weapon is Staff },
		effect = { DisplayWieldEffectEffect("${wieldParameters.person} looks satisfied with his new ${wieldParameters.weapon}.") }
	)

	+shopSceneRule(
		applicable = { wieldEffect is UpdateWeaponWieldEffect && wieldParameters.weapon is Dagger },
		effect = { DisplayWieldEffectEffect("${wieldParameters.person} takes the ${wieldParameters.weapon} begrudgingly.") }
	)
}
```

### Demonstration
Creative thinking led to the narrative shown in the [demonstration](https://github.com/devbridie/wizardsandwarriors/blob/master/sample/src/main/kotlin/com/devbridie/wizardsandwarriors/sample/Main.kt), demonstrating the basics of the rule system.

With this, the initial goal was completed.

### Extensions
Suppose I were a user of the framework: what features would I want? In context of game development, I immediately
thought of expansion packs: What if `Paladin`s were added to the game? How could this new type of person and other related logic
be added to the system without disturbing existing logic?

For this, being able to nest rulebooks became a vital feature.