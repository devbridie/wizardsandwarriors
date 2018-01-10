package com.devbridie.wizardsandwarriors.sample.models


data class Enemy(
        val type: EnemyType
) : Combattable {
    override fun toString() = type.toString()
}