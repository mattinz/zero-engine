package test.entities

import zero.base.Component
import zero.base.Entity
import zero.base.ISystem
import zero.components.TextComponent
import zero.components.TransformComponent
import kotlin.reflect.KClass

class ScoreDisplayEntity: Entity() {
    override val components: MutableMap<KClass<out Component>, Component> = mutableMapOf(
            TransformComponent::class to TransformComponent(),
            TextComponent::class to TextComponent("SCORE", 40.0f)
    )
    override val systemKeys: MutableSet<KClass<out ISystem>> = mutableSetOf()
}