package org.geepawhill.wordle

import javafx.scene.Parent
import tornadofx.*

class FirstSolverView(model: FirstSolverModel) : Fragment() {

    override val root: Parent = borderpane {
        top = toolbar {
            button("Prepare") {
                font = Styles.textFont
                enableWhen(model.needsPreparing)
                action {
                    model.prepare()
                }
            }
            textfield(model.firstGuess) {
                font = Styles.textFont
            }
            button("Run 2315") {
                font = Styles.textFont
                action {
                    model.run2315()
                }
            }

            button("Run Solutions") {
                font = Styles.textFont
                action {
                    model.runSolutions()
                }
            }
        }
        center = tableview(model.batches) {
            columnResizePolicy = SmartResize.POLICY
            readonlyColumn("ID", Batch::id)
            readonlyColumn("W", Batch::wins)
            readonlyColumn("Average", Batch::totalGuesses)
            rowExpander(expandOnDoubleClick = true) {
                paddingLeft = expanderColumn.width
                tableview(it.problems) {
                    columnResizePolicy = SmartResize.POLICY
                    readonlyColumn("W/L", Problem::win).cellFormat {
                        if (it == true) {
                            text = "W"
                            background = Styles.winBackground
                        } else {
                            text = "L"
                            background = Styles.lossBackground
                        }
                    }
                    readonlyColumn("Answer", Problem::answer).cellFormat {
                        text = it
                        font = Styles.textFont
                    }
                    readonlyColumn("Size", Problem::size).cellFormat {
                        text = it.toString()
                        font = Styles.textFont
                    }
                    readonlyColumn("Guesses", Problem::guessesString).cellFormat {
                        text = it
                        font = Styles.textFont
                    }
                }
            }
        }
    }
}
