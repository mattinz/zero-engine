package test

import zero.base.IInputService
import zero.model.Vector2

class SwingInputService(private val window: SwingRenderer): IInputService {
    override val mouseScreenPosition
        get() = internalMouseScreenPosition

    private var internalMouseScreenPosition = Vector2()

    override fun update() {
        internalMouseScreenPosition = window.getMousePositionOnScreen()
    }

    override fun isButtonDown(buttonKey: IInputService.ButtonKey): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isButtonPressed(buttonKey: IInputService.ButtonKey): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isButtonReleased(buttonKey: IInputService.ButtonKey) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}