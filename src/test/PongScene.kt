package test

import test.entities.PlayerPaddleEntity
import test.entities.ScoreDisplayEntity
import zero.base.Entity
import zero.base.IInputService
import zero.base.IScene
import zero.components.TransformComponent
import zero.model.Vector2

class PongScene: IScene {
    override val entities: List<Entity>
    override val name = "Zero Pong"

    init {
        val leftPlayer = PlayerPaddleEntity(left = IInputService.InputKey.NULL, right = IInputService.InputKey.NULL)
        (leftPlayer.getComponent(TransformComponent::class) as TransformComponent).position = Vector2(200.0f, 450.0f)

        val rightPlayer = PlayerPaddleEntity(IInputService.InputKey.UP, IInputService.InputKey.DOWN, IInputService.InputKey.NULL, IInputService.InputKey.NULL)
        (rightPlayer.getComponent(TransformComponent::class) as TransformComponent).position = Vector2(1400.0f, 450.0f)

        val scoreBoard = ScoreDisplayEntity()
        (scoreBoard.getComponent(TransformComponent::class) as TransformComponent).position = Vector2(800.0f, 100.0f)

        entities = listOf(leftPlayer, rightPlayer, scoreBoard)
    }
}