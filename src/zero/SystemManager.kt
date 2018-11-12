package zero

import zero.base.AbstractEngine
import zero.base.Entity
import zero.base.ISystem
import zero.base.ISystemManager
import zero.components.MovementControlComponent
import zero.systems.DirectionalMovementControlSystem
import zero.systems.FollowMouseSystem
import zero.systems.MovementSystem
import kotlin.reflect.KClass

class SystemManager: ISystemManager {

    private val systemMap = mutableMapOf<KClass<out ISystem>, ISystem>()

    init {
        systemMap[FollowMouseSystem::class] = FollowMouseSystem()
        systemMap[MovementSystem::class] = MovementSystem()
        systemMap[DirectionalMovementControlSystem:: class] = DirectionalMovementControlSystem()
    }

    override fun update(engine: AbstractEngine, entities: List<Entity>) {
        //TODO: This could potentially be multi-threaded
        entities.forEach { entity ->
            entity.systemKeys.forEach { key ->
                systemMap[key]?.update(engine, entity)
            }
        }
    }
}