[com.devbridie.wizardsandwarriors.dsl](index.md) / [rule](.)

# rule

`fun <CP : `[`CommandParameters`](../com.devbridie.wizardsandwarriors.framework/-command-parameters/index.md)`, E : `[`Effect`](../com.devbridie.wizardsandwarriors.framework/-effect/index.md)`> rule(applicable: CP.() -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, effect: CP.() -> E): `[`Rule`](../com.devbridie.wizardsandwarriors.framework/-rule/index.md)`<CP, E>`

Builds a [Rule](../com.devbridie.wizardsandwarriors.framework/-rule/index.md) using a DSL.

### Parameters

`applicable` - a function that specifies if this rule can be used given these parameters. [CP](#) is given as receiver.

`effect` - function that specifies what the effect is of applying this [Rule](../com.devbridie.wizardsandwarriors.framework/-rule/index.md). [CP](#) is given as receiver.

**See Also**

[Rule](../com.devbridie.wizardsandwarriors.framework/-rule/index.md)

