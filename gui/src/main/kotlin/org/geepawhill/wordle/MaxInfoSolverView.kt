package org.geepawhill.wordle

import javafx.scene.Parent
import tornadofx.*

class MaxInfoSolverView(model: MaxInfoModel) : Fragment() {

    override val root: Parent = borderpane {
        top = toolbar {
            button("Prepare") {
                font = Styles.textFont
                enableWhen(model.needsPreparing)
                action {
                    model.prepare()
                }
            }
            button("Run 2315") {
                font = Styles.textFont
                action {
                    model.run2315()
                }
            }
        }
        center = BatchView(model).root
    }
}
