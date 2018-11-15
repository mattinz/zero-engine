package test.pong

import test.TestEngine
import test.contexts.swing.SwingContext
import zero.SystemManager

fun main(args: Array<String>) {

    val context = SwingContext()
    val systemManager = SystemManager()
    val engine = TestEngine(context, PongScene(), systemManager)
    engine.start()
}