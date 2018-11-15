package zero.systems

import zero.base.AbstractEngine
import zero.base.Entity
import zero.base.ISystem
import zero.components.MovementComponent
import zero.components.TransformComponent

class MovementSystem: ISystem {
    override fun onStart(){}

    override fun onFinish(){}

    override fun update(engine: AbstractEngine, entity: Entity) {
        val transform = entity.getComponent(TransformComponent::class) as TransformComponent
        val movement = entity.getComponent(MovementComponent::class) as MovementComponent

        transform.position.x += movement.rate.x
        transform.position.y += movement.rate.y
    }
}