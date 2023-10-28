package org.geepawhill.wordle

import javafx.scene.Parent
import tornadofx.*

class DatasetView(val datasetModel: DatasetModel) : Fragment() {
    override val root: Parent = borderpane {
        center = label("Dataset goes here") {
            font = Styles.textFont
        }
    }

}
