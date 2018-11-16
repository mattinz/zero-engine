package test.pong.entities

import test.pong.systems.PongScoreSystem
import test.pong.components.ScoreObjectComponent
import zero.base.Component
import zero.base.Entity
import zero.base.ISystem
import zero.components.CircleComponent
import zero.components.MovementComponent
import zero.components.TransformComponent
import zero.model.Vector2
import zero.systems.MovementSystem
import java.awt.Color
import kotlin.reflect.KClass

class PongBallEntity: Entity() {
    override val components: MutableMap<KClass<out Component>, Component> = mutableMapOf(
            TransformComponent::class to TransformComponent(),
            MovementComponent::class to MovementComponent(Vector2(3.0f, 0.0f)),
            CircleComponent::class to CircleComponent(30, 30, Color.BLACK),
            ScoreObjectComponent::class to ScoreObjectComponent(30, 30)
    )
    override val systemKeys: MutableSet<KClass<out ISystem>> = mutableSetOf(
            MovementSystem::class,
            PongScoreSystem::class
    )
}