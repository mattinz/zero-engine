package zero

import test.pong.systems.PongScoreSystem
import zero.base.AbstractEngine
import zero.base.Entity
import zero.base.ISystem
import zero.base.ISystemManager
import zero.systems.DirectionalMovementControlSystem
import zero.systems.FollowMouseSystem
import zero.systems.MovementSystem
import kotlin.reflect.KClass

class SystemManager: ISystemManager {

    private val systemMap = mutableMapOf<KClass<out ISystem>, ISystem>()

    init {
        systemMap[FollowMouseSystem::class] = FollowMouseSystem()
        systemMap[MovementSystem::class] = MovementSystem()
        systemMap[DirectionalMovementControlSystem::class] = DirectionalMovementControlSystem()
        systemMap[PongScoreSystem::class] = PongScoreSystem()
    }

    override fun update(engine: AbstractEngine, entities: List<Entity>) {
        //TODO: This could potentially be multi-threaded

        systemMap.values.forEach { it.onStart() }
        entities.forEach { entity ->
            entity.systemKeys.forEach { key ->
                systemMap[key]?.update(engine, entity)
            }
        }
        systemMap.values.forEach { it.onFinish() }
    }
}