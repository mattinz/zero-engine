package zero.base

interface ISystem {
    fun onStart()
    fun update(engine: AbstractEngine, entity: Entity)
    fun onFinish()
}