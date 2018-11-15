package test.pong.entities

import test.pong.PongScoreSystem
import test.pong.components.ScoreAreaComponent
import zero.base.Component
import zero.base.Entity
import zero.base.ISystem
import zero.components.RectangleComponent
import zero.components.TransformComponent
import kotlin.reflect.KClass

class PongGoalEntity(player: Int, width: Int, height: Int): Entity() {
    override val components: MutableMap<KClass<out Component>, Component> = mutableMapOf(
            TransformComponent::class to TransformComponent(),
            ScoreAreaComponent::class to ScoreAreaComponent(player, width, height),
            RectangleComponent::class to RectangleComponent(width, height)
    )
    override val systemKeys: MutableSet<KClass<out ISystem>> = mutableSetOf(
            PongScoreSystem::class
    )
}