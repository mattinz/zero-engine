package zero.base

import zero.model.Vector2

interface IInputService: IService {
    val mouseScreenPosition: Vector2
    fun isButtonDown(inputKey: InputKey): Boolean
    fun isButtonPressed(inputKey: InputKey): Boolean
    fun isButtonReleased(inputKey: InputKey)

    enum class InputKey {
        A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z,
        UP, DOWN, LEFT, RIGHT
    }
}