package zero.base

abstract class AbstractEngine(private val context: IContext,
                              protected val scene: IScene,
                              protected val systems: ISystemManager) {
    protected val renderer: IRenderer = context.renderer
    val inputService: IInputService = context.inputService

    abstract fun start()
}