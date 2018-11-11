package zero.components

import zero.base.Component
import zero.base.IRenderable
import java.awt.Color

data class RectangleComponent(var width: Int, var height: Int, var color: Color = Color.BLUE): Component(), IRenderable