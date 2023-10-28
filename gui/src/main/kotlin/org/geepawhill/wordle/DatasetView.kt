package org.geepawhill.wordle

import javafx.scene.Parent
import javafx.scene.layout.Priority
import tornadofx.*

class DatasetView(val datasetModel: DatasetModel) : Fragment() {
    override val root: Parent = borderpane {
        center = vbox {
            stackpane {
                background = Styles.headerBackground
                vbox {
                    label(datasetModel.guessPath) {
                        font = Styles.textFont
                    }
                    label(datasetModel.solutionPath) {
                        font = Styles.textFont
                    }
                }
            }
            hbox {
                vgrow = Priority.ALWAYS
                vbox {
                    stackpane {
                        background = Styles.headerBackground
                        label("Guesses") {
                            font = Styles.textFont
                        }
                    }
                    listview(datasetModel.guesses) {
                        style = "-fx-font-size:20.0"
                        vgrow = Priority.ALWAYS
                    }
                }
                vbox {
                    stackpane {
                        background = Styles.headerBackground
                        label("Solutions") {
                            font = Styles.textFont
                        }
                    }
                    listview(datasetModel.solutions) {
                        style = "-fx-font-size:20.0"
                        vgrow = Priority.ALWAYS
                    }
                }
                this += FrequencyView("Overall", datasetModel.overall)
                this += FrequencyView("Position 0", datasetModel.position0)
                this += FrequencyView("Position 1", datasetModel.position1)
                this += FrequencyView("Position 2", datasetModel.position2)
                this += FrequencyView("Position 3", datasetModel.position3)
                this += FrequencyView("Position 4", datasetModel.position4)
            }
        }
    }

}
