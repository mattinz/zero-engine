package zero.systems

import zero.base.AbstractEngine
import zero.base.Entity
import zero.base.ISystem
import zero.components.MovementComponent
import zero.components.MovementControlComponent

class DirectionalMovementControlSystem: ISystem {
    override fun update(engine: AbstractEngine, entity: Entity) {
        val movementControlComponent = entity.getComponent(MovementControlComponent::class) as MovementControlComponent
        val movementComponent = entity.getComponent(MovementComponent::class) as MovementComponent
        val speed = 10.0f

        movementComponent.rate.x = 0.0f
        movementComponent.rate.y = 0.0f

        if(engine.inputService.isButtonDown(movementControlComponent.up)) {
            movementComponent.rate.y -= speed
        }
        if(engine.inputService.isButtonDown(movementControlComponent.down)) {
            movementComponent.rate.y += speed
        }
        if(engine.inputService.isButtonDown(movementControlComponent.left)) {
            movementComponent.rate.x -= speed
        }
        if(engine.inputService.isButtonDown(movementControlComponent.right)) {
            movementComponent.rate.x += speed
        }

        println(movementComponent)
    }
}