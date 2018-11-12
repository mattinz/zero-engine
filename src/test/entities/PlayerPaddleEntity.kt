package test.entities

import zero.base.Component
import zero.base.Entity
import zero.base.IInputService
import zero.base.ISystem
import zero.components.MovementComponent
import zero.components.MovementControlComponent
import zero.components.RectangleComponent
import zero.components.TransformComponent
import zero.systems.DirectionalMovementControlSystem
import zero.systems.MovementSystem
import java.awt.Color
import kotlin.reflect.KClass

class PlayerPaddleEntity(up: IInputService.InputKey = IInputService.InputKey.W,
                         down: IInputService.InputKey = IInputService.InputKey.S,
                         left: IInputService.InputKey = IInputService.InputKey.A,
                         right: IInputService.InputKey = IInputService.InputKey.D): Entity() {
    override val components: MutableMap<KClass<out Component>, Component> = mutableMapOf(
            TransformComponent::class to TransformComponent(),
            MovementComponent::class to MovementComponent(),
            MovementControlComponent::class to MovementControlComponent(up, down, left, right),
            RectangleComponent::class to RectangleComponent(20, 100, Color.BLACK)
    )
    override val systemKeys: MutableSet<KClass<out ISystem>> = mutableSetOf(DirectionalMovementControlSystem::class, MovementSystem::class)
}