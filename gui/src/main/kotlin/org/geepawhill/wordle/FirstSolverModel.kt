package org.geepawhill.wordle

import javafx.beans.property.SimpleStringProperty

class FirstSolverModel(val dataset: Dataset) {

    val firstGuess = SimpleStringProperty("VALOR")
}