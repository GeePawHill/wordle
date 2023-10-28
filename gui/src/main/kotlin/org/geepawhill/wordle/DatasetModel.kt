package org.geepawhill.wordle

import javafx.beans.property.SimpleStringProperty
import tornadofx.*

class DatasetModel {

    val guessPath = SimpleStringProperty("N/A")
    val solutionPath = SimpleStringProperty("N/A")
    val guesses = observableListOf<String>()
    val solutions = observableListOf<String>()
    val overall = observableListOf<Frequency>()
    val position0 = observableListOf<Frequency>()
    val position1 = observableListOf<Frequency>()
    val position2 = observableListOf<Frequency>()
    val position3 = observableListOf<Frequency>()
    val position4 = observableListOf<Frequency>()
    fun load(dataset: Dataset) {
        guessPath.set(dataset.guessPath.toString())
        solutionPath.set(dataset.solutionPath.toString())
        guesses.clear()
        guesses.addAll(dataset.guesses)
        solutions.clear()
        solutions.addAll(dataset.solutions)
        val counter = Counter()
        counter.count(dataset.combined)
        overall.clear()
        overall.addAll(counter.sortedAnywhere())
        position0.clear()
        position0.addAll(counter.sortedPositional(0))
        position1.clear()
        position1.addAll(counter.sortedPositional(1))
        position2.clear()
        position2.addAll(counter.sortedPositional(2))
        position3.clear()
        position3.addAll(counter.sortedPositional(3))
        position4.clear()
        position4.addAll(counter.sortedPositional(4))
    }
}
