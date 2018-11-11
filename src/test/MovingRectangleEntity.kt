package test

import zero.base.Component
import zero.base.Entity
import zero.base.ISystem
import zero.components.MovementComponent
import zero.components.RectangleComponent
import zero.components.TransformComponent
import zero.model.Vector2
import zero.systems.MovementSystem
import java.awt.Color
import kotlin.reflect.KClass

class MovingRectangleEntity(movement: Vector2): Entity() {
    override val components: MutableMap<KClass<out Component>, Component> = mutableMapOf(
            TransformComponent::class to TransformComponent(),
            MovementComponent::class to MovementComponent(movement),
            RectangleComponent::class to RectangleComponent(20, 20, Color.BLUE)
    )
    override val systemKeys: MutableSet<KClass<out ISystem>> = mutableSetOf(MovementSystem::class)
}