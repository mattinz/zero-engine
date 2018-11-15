package test

import zero.base.AbstractEngine
import zero.base.IContext
import zero.base.IScene
import zero.base.ISystemManager

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