package zero.systems

import zero.base.AbstractEngine
import zero.base.Entity
import zero.base.ISystem
import zero.components.TransformComponent

class FollowMouseSystem: ISystem {
    override fun onStart(){}

    override fun onFinish(){}

    override fun update(engine: AbstractEngine, entity: Entity) {
        val transform = entity.getComponent(TransformComponent::class) as TransformComponent
        transform.position = engine.inputService.mouseScreenPosition
    }
}