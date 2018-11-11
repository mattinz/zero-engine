package test

import zero.base.Entity
import zero.base.IRenderable
import zero.base.IRenderer
import zero.components.RectangleComponent
import zero.components.TransformComponent
import zero.model.Vector2
import java.awt.Dimension
import java.awt.Graphics
import java.awt.MouseInfo
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.SwingUtilities

class SwingRenderer(preferredSize: Dimension, name:String): IRenderer {

    private val frame = JFrame(name)
    private val renderPanel = RenderPanel(preferredSize)

    init {
        SwingUtilities.invokeLater {
            frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
            frame.add(renderPanel)
            frame.pack()
            frame.isVisible = true
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

private class RenderPanel(preferredSize: Dimension): JPanel() {

    private var entitiesToRender = listOf<Entity>()

    init {
        this.preferredSize = preferredSize
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
                    }
                }
            }
        }
    }
}