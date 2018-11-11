package zero.components

import zero.base.Component
import zero.model.Vector2

data class MovementComponent(var rate: Vector2 = Vector2()): Component()