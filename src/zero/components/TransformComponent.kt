package zero.components

import zero.base.Component
import zero.model.Vector2

data class TransformComponent(var position: Vector2 = Vector2(),
                              var scale: Vector2 = Vector2(),
                              var rotation: Float = 0.0f): Component()