package test.contexts.swing

import zero.base.IInputService
import zero.model.Vector2

class SwingInputService(private val context: SwingContext): IInputService {
    override val mouseScreenPosition
        get() = internalMouseScreenPosition
    private var internalMouseScreenPosition = Vector2()

    private val currentInputs = hashSetOf<IInputService.InputKey>()

    override fun update() {
        internalMouseScreenPosition = (context.renderer as SwingRenderer).getMousePositionOnScreen()
    }

    override fun isButtonDown(inputKey: IInputService.InputKey): Boolean {
        return currentInputs.contains(inputKey)
    }

    override fun isButtonPressed(inputKey: IInputService.InputKey): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isButtonReleased(inputKey: IInputService.InputKey) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun keyPressed(inputKey: IInputService.InputKey) {
        println(inputKey)
        currentInputs.add(inputKey)
    }

    fun keyReleased(inputKey: IInputService.InputKey) {
        currentInputs.remove(inputKey)
    }
}