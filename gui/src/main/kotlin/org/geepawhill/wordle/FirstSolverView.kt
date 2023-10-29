package org.geepawhill.wordle

import javafx.scene.Parent
import tornadofx.*

class FirstSolverView(model: FirstSolverModel) : Fragment() {
    override val root: Parent = borderpane {
        top = toolbar {
            button("Run 2315") {
                action {
                    model.run2315()
                }
            }
        }
        center = tableview(model.problems) {
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
