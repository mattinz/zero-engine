package zero.components

import zero.base.Component
import zero.model.Vector2

data class TransformComponent(var position: Vector2 = Vector2(),
                              var scale: Vector2 = Vector2(1.0f, 1.0f),
                              var rotation: Float = 0.0f): Component()