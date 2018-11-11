package test

import zero.base.Component
import zero.base.Entity
import zero.base.ISystem
import zero.components.RectangleComponent
import zero.components.TransformComponent
import zero.systems.FollowMouseSystem
import java.awt.Color
import kotlin.reflect.KClass

class FollowMouseRectangleEntity(width:Int, height:Int, color:Color): Entity() {
    override val components: MutableMap<KClass<out Component>, Component> = mutableMapOf(
            TransformComponent::class to TransformComponent(),
            RectangleComponent::class to RectangleComponent(width, height, color)
    )
    override val systemKeys: MutableSet<KClass<out ISystem>> = mutableSetOf(FollowMouseSystem::class)
}