package org.geepawhill.wordle

import javafx.collections.ObservableList
import javafx.scene.layout.Priority
import tornadofx.*

class FrequencyView(title: String, items: ObservableList<Frequency>) : Fragment() {

    override val root = vbox {
        maxWidth = 150.0
        stackpane {
            background = Styles.headerBackground
            label(title) {
                font = Styles.textFont
            }
        }
        tableview(items) {
            vgrow = Priority.ALWAYS
            readonlyColumn("Char", Frequency::letter).cellFormat {
                text = it.toString()
                font = Styles.textFont
            }
            readonlyColumn("Freq", Frequency::count).cellFormat {
                text = it.toString()
                font = Styles.textFont
            }
        }
    }
}

