package test.pong.entities

import test.pong.systems.PongScoreSystem
import test.pong.components.ScoreTrackerComponent
import zero.base.Component
import zero.base.Entity
import zero.base.ISystem
import zero.components.TextComponent
import zero.components.TransformComponent
import kotlin.reflect.KClass

class ScoreDisplayEntity: Entity() {
    override val components: MutableMap<KClass<out Component>, Component> = mutableMapOf(
            TransformComponent::class to TransformComponent(),
            TextComponent::class to TextComponent("0 - 0", 80.0f),
            ScoreTrackerComponent::class to ScoreTrackerComponent(2)
    )
    override val systemKeys: MutableSet<KClass<out ISystem>> = mutableSetOf(PongScoreSystem::class)
}