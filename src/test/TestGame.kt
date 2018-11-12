package test

import test.contexts.swing.SwingContext
import test.entities.FollowMouseRectangleEntity
import test.entities.MovingRectangleEntity
import test.entities.PlayerPaddleEntity
import zero.SystemManager
import zero.base.*
import zero.model.Vector2
import java.awt.Color

class TestEngine(context: IContext, scene: IScene, systemManager: ISystemManager): AbstractEngine(context, scene, systemManager) {
    override fun start() {
        while(true) {
            inputService.update()
            systems.update(this, scene.entities)
            renderer.render(scene.entities)
            Thread.sleep(32)
        }
    }
}

fun main(args: Array<String>) {

    val context = SwingContext()

    val systemManager = SystemManager()

    val scene = object : IScene {
        override val entities: List<Entity> = listOf(MovingRectangleEntity(Vector2(1.0f, 1.0f)),
                MovingRectangleEntity(Vector2(2.0f, 1.0f)),
                FollowMouseRectangleEntity(40, 4, Color.RED),
                FollowMouseRectangleEntity(4, 40, Color.RED),
                PlayerPaddleEntity(),
                PlayerPaddleEntity(IInputService.InputKey.UP, IInputService.InputKey.DOWN, IInputService.InputKey.LEFT, IInputService.InputKey.RIGHT))
        override val name: String = "Test Scene"
    }

    val engine = TestEngine(context, PongScene(), systemManager)
    engine.start()
}