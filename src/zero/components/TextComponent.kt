package zero.components

import zero.base.Component
import zero.base.IRenderable
import java.awt.Color

data class TextComponent(var text: String, var size: Float, var color: Color = Color.BLACK): Component(), IRenderable