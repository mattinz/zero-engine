package test.pong.components

import zero.base.Component

data class ScoreTrackerComponent(private val numPlayers:Int): Component() {
    val scores = IntArray(numPlayers) { 0 }
}