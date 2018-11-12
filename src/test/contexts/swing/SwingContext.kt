package test.contexts.swing

import zero.base.IContext
import zero.base.IInputService
import zero.base.IRenderer
import java.awt.Dimension

class SwingContext: IContext {
    override val renderer: IRenderer = SwingRenderer(this, Dimension(1600, 900), "Test Game")
    override val inputService: IInputService = SwingInputService(this)
}