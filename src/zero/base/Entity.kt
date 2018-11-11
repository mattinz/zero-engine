package zero.base

import kotlin.reflect.KClass

abstract class Entity {
    protected abstract val components: MutableMap<KClass<out Component>, Component>
    abstract val systemKeys: MutableSet<KClass<out ISystem>>

    fun addComponent(component: Component) {
        if(!components.containsKey(component::class)) {
            components[component::class] = component
        }
    }

    fun getComponent(componentClass: KClass<out Component>): Component? {
        return components[componentClass]
    }

    fun getComponentsList(): List<Component> {
        return components.values.toList()
    }

    fun removeComponent(componentClass: KClass<out Component>): Boolean {
        val component = components.remove(componentClass)
        return component != null
    }
}