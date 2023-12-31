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

            button("Super Run") {
                font = Styles.textFont
                action {
                    model.superRun()
                }
            }
        }
        center = BatchView(model).root
    }
}
