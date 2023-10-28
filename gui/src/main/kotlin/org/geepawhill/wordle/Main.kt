package org.geepawhill.wordle

import javafx.application.Application
import javafx.scene.Scene
import javafx.stage.Stage


class Main : Application() {

    val datasetModel = DatasetModel()

    override fun start(primaryStage: Stage?) {
        val controller = primaryStage!!
        val mainView = MainView(datasetModel)
        controller.scene = Scene(mainView.root)
        controller.show()
    }
}


fun main() {
    Application.launch(Main::class.java)
}
