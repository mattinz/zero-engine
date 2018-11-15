package test.pong

import test.pong.components.ScoreAreaComponent
import test.pong.components.ScoreObjectComponent
import test.pong.components.ScoreTrackerComponent
import zero.base.AbstractEngine
import zero.base.Entity
import zero.base.ISystem
import zero.components.TextComponent

class PongScoreSystem: ISystem {

    private lateinit var scoreBoard: Entity
    private val scoreObjects = mutableListOf<Entity>()
    private val scoreAreas = mutableListOf<Entity>()

    override fun onStart() {
        //
    }

    override fun update(engine: AbstractEngine, entity: Entity) {
        when {
            entity.getComponent(ScoreTrackerComponent::class) != null -> scoreBoard = entity
            entity.getComponent(ScoreTrackerComponent::class) != null -> scoreObjects.add(entity)
            entity.getComponent(ScoreAreaComponent::class) != null -> scoreAreas.add(entity)
        }
    }

    override fun onFinish() {
        scoreObjects.forEach { scoreObject ->
            val scoreObjectComponent = scoreObject.getComponent(ScoreObjectComponent::class) as ScoreObjectComponent
            if(scoreObjectComponent.isActive) {
                scoreAreas.forEach { scoreArea ->
                    if (isObjectInArea(scoreObject, scoreArea)) {
                        scoreObjectComponent.isActive = false
                        val scoreAreaComponent = scoreArea.getComponent(ScoreAreaComponent::class) as ScoreAreaComponent
                        val scoreTrackerComponent = scoreBoard.getComponent(ScoreTrackerComponent::class) as ScoreTrackerComponent
                        when(scoreAreaComponent.player) {
                            0 -> scoreTrackerComponent.scores[1]++
                            1 -> scoreTrackerComponent.scores[0]++
                        }
                        (scoreBoard.getComponent(TextComponent::class) as TextComponent).text = "" + scoreTrackerComponent.scores[0] + " - " + scoreTrackerComponent.scores[1]
                    }
                }
            }
        }
    }

    private fun isObjectInArea(scoreObject: Entity, scoreArea: Entity):Boolean {
        //TODO check the positions and sizes of the objects, return true if the object is completely within the area
    }
}