package org.geepawhill.wordle

import javafx.application.Application
import javafx.scene.Scene
import javafx.stage.Stage


class Main : Application() {

    val mainModel = MainModel()

    override fun start(primaryStage: Stage?) {
        val controller = primaryStage!!
        val mainView = MainView(mainModel)
        controller.scene = Scene(mainView.root)
        controller.show()
    }
}


fun main() {
    Application.launch(Main::class.java)
}
