package com.devbridie.wizardsandwarriors.sample.models


data class Enemy(
        val type: EnemyType,
        val id: Int = Counter.id++
) : Combattable {
    companion object Counter {
        var id = 0
    }

    override fun toString() = type.toString()
}