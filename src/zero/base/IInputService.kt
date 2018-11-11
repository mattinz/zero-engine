package zero.base

import zero.model.Vector2

interface IInputService: IService {
    val mouseScreenPosition: Vector2
    fun isButtonDown(buttonKey: ButtonKey): Boolean
    fun isButtonPressed(buttonKey: ButtonKey): Boolean
    fun isButtonReleased(buttonKey: ButtonKey)

    enum class ButtonKey {
        A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z,
        UP, DOWN
    }
}