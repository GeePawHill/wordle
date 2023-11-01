package org.geepawhill.wordle

import javafx.collections.ObservableList

interface BatchModel {
    val batches: ObservableList<Batch>
}