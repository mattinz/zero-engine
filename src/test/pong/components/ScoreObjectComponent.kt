package test.pong.components

import zero.base.Component

data class ScoreObjectComponent(var width: Int, var height: Int, var isActive: Boolean = true): Component() {
}