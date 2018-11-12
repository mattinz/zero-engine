package test.contexts.swing

import zero.base.Entity
import zero.base.IInputService
import zero.base.IRenderable
import zero.base.IRenderer
import zero.components.RectangleComponent
import zero.components.TextComponent
import zero.components.TransformComponent
import zero.model.Vector2
import java.awt.Dimension
import java.awt.Graphics
import java.awt.MouseInfo
import java.awt.event.KeyEvent
import java.awt.event.KeyListener
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.SwingUtilities

class SwingRenderer(context: SwingContext, preferredSize: Dimension, name:String): IRenderer {

    private val frame = JFrame(name)
    private val renderPanel = RenderPanel(context, preferredSize)

    init {
        SwingUtilities.invokeLater {
            frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
            frame.add(renderPanel)
            frame.pack()
            frame.isVisible = true
            renderPanel.requestFocus()
        }
    }

    override fun render(entities: List<Entity>) {
        renderPanel.render(entities)
    }

    fun getMousePositionOnScreen(): Vector2 {
        val mousePosition = MouseInfo.getPointerInfo().location
        SwingUtilities.convertPointFromScreen(mousePosition, renderPanel)
        return Vector2(mousePosition.x.toFloat(), mousePosition.y.toFloat())
    }
}

private class RenderPanel(context: SwingContext, preferredSize: Dimension): JPanel() {

    private var entitiesToRender = listOf<Entity>()

    init {
        this.preferredSize = preferredSize
        addKeyListener(object : KeyListener {
            override fun keyTyped(e: KeyEvent?) {
                //Do nothing
            }

            override fun keyPressed(e: KeyEvent?) {
                val inputKey = inputKeyMap[e?.keyCode]
                if(inputKey != null) {
                    (context.inputService as SwingInputService).keyPressed(inputKey)
                }
            }

            override fun keyReleased(e: KeyEvent?) {
                val inputKey = inputKeyMap[e?.keyCode]
                if(inputKey != null) {
                    (context.inputService as SwingInputService).keyReleased(inputKey)
                }
            }

        })
    }

    fun render(entities: List<Entity>) {
        entitiesToRender = entities
        repaint()
    }

    override fun paintComponent(g: Graphics?) {
        super.paintComponent(g)
        entitiesToRender.forEach { entity ->
            entity.getComponentsList().forEach { component ->
                if(component is IRenderable) {
                    val transformComponent = entity.getComponent(TransformComponent::class) as TransformComponent
                    when(component) {
                        is RectangleComponent -> {
                            g?.color = component.color
                            g?.fillRect(transformComponent.position.x.toInt() - component.width/2,
                                    transformComponent.position.y.toInt() - component.height/2,
                                    component.width, component.height)
                        }
                        is TextComponent -> {
                            g?.color = component.color
                            g?.drawString(component.text, transformComponent.position.x.toInt(), transformComponent.position.y.toInt())
                        }
                    }
                }
            }
        }
    }
}

private val inputKeyMap = mapOf(
        KeyEvent.VK_UP to IInputService.InputKey.UP,
        KeyEvent.VK_DOWN to IInputService.InputKey.DOWN,
        KeyEvent.VK_LEFT to IInputService.InputKey.LEFT,
        KeyEvent.VK_RIGHT to IInputService.InputKey.RIGHT,
        KeyEvent.VK_A to IInputService.InputKey.A,
        KeyEvent.VK_D to IInputService.InputKey.D,
        KeyEvent.VK_S to IInputService.InputKey.S,
        KeyEvent.VK_W to IInputService.InputKey.W
)