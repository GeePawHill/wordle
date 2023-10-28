package org.geepawhill.wordle

import tornadofx.*

class MainView(val mainModel: MainModel) : View() {
    override val root = borderpane {
        minHeight = 1000.0
        minWidth = 1500.0
        center = tabpane {
            tab("Dataset") {
                this += DatasetView(mainModel.datasetModel)
            }
            tab("FirstSolvert") {
                this += FirstSolverView(mainModel.firstSolverModel)
            }
        }
    }
}