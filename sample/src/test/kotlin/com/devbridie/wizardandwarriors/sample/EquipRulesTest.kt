package com.devbridie.wizardandwarriors.sample

import com.devbridie.wizardsandwarriors.sample.WizardsAndWarriorsGame
import com.devbridie.wizardsandwarriors.sample.models.*
import com.devbridie.wizardsandwarriors.sample.wield.*
import io.kotlintest.matchers.haveSize
import io.kotlintest.matchers.should
import io.kotlintest.matchers.shouldBe
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import java.util.*
import kotlin.reflect.KClass
import kotlin.reflect.full.isSubclassOf

object EquipRulesTest : Spek({
    lateinit var game: WizardsAndWarriorsGame

    beforeEachTest {
        game = WizardsAndWarriorsGame()
    }

    val table = listOf(
            row(Wizard, Staff, UpdateWeaponWieldEffect::class),
            row(Wizard, Dagger, UpdateWeaponWieldEffect::class),
            row(Wizard, Sword, WeaponTooHeavyWieldEffect::class),
            row(Wizard, HolyMoonSword, NotAPaladinWieldEffect::class),
            row(Warrior, Staff, WeaponTooMagicalWieldEffect::class),
            row(Warrior, Dagger, UpdateWeaponWieldEffect::class),
            row(Warrior, Sword, UpdateWeaponWieldEffect::class),
            row(Warrior, HolyMoonSword, NotAPaladinWieldEffect::class),
            row(Paladin, Staff, WeaponTooMagicalWieldEffect::class),
            row(Paladin, Dagger, UpdateWeaponWieldEffect::class),
            row(Paladin, Sword, UpdateWeaponWieldEffect::class),
            row(Paladin, HolyMoonSword, UpdateWeaponWieldEffect::class)
    )

    table.groupBy { it.personType }.forEach { (personType, rows) ->
        given("a $personType") {
            rows.forEach { (_, weapon, effectClass) ->
                on("equip $weapon") {
                    val person = Person(type = personType).also {
                        game.spawnPerson(it)
                    }
                    val effects = game.wield(person, weapon)

                    it("should result in ${effectClass.simpleName}") {
                        effects should haveSize(1)
                        effects.first()::class shouldBe effectClass
                    }

                    if (effectClass.isSubclassOf(UpdateWeaponWieldEffect::class)) it("should be wielded") {
                        person.weapon shouldBe Optional.of(weapon)
                    }
                    else it("should not be wielded") {
                        person.weapon shouldBe Optional.empty<Weapon>()
                    }
                }
            }
        }
    }
})

data class WieldRow(val personType: PersonType, val weapon: Weapon, val effectClass: KClass<*>)

fun row(type: PersonType, weapon: Weapon, effectClass: KClass<out WieldEffect>): WieldRow {
    return WieldRow(type, weapon, effectClass)
}