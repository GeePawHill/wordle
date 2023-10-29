package org.geepawhill.wordle

import javafx.beans.property.SimpleStringProperty
import tornadofx.*

class Problem(val answer: String, val guesses: List<String>) {
    val size = guesses.size
    val guessesString = guesses.joinToString(" ")
    val win = guesses.size < 7
}

class FirstSolverModel(val dataset: Dataset) : Reporter {

    val problems = observableListOf<Problem>()

    val firstGuess = SimpleStringProperty("VALOR")
    val solver = FirstSolver(dataset, firstGuess.value)

    val guesses = mutableListOf<String>()

    fun run2315() {
        val runner = Runner(this)
        task {
            runner.run(solver, dataset)
        }
    }

    override fun startBatch(id: String) {
    }

    override fun endBatch() {
    }

    override fun startRun(id: String) {
        guesses.clear()
    }

    override fun guess(guess: String, result: String) {
        guesses += guess
    }

    override fun endRun(answer: String) {
        val problem = Problem(answer, guesses)
        runLater {
            problems.add(problem)
        }
    }
}