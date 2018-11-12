package zero.components

import zero.base.Component
import zero.base.IInputService

data class MovementControlComponent(
        val up: IInputService.InputKey = IInputService.InputKey.UP,
        val down: IInputService.InputKey = IInputService.InputKey.DOWN,
        val left: IInputService.InputKey = IInputService.InputKey.LEFT,
        val right: IInputService.InputKey = IInputService.InputKey.RIGHT): Component()