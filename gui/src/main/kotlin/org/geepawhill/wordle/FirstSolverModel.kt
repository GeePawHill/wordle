package org.geepawhill.wordle

import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.*

class Problem(val answer: String, guesses: List<String>) {
    val size = guesses.size
    val guessesString = guesses.joinToString(" ")
    val win = guesses.size < 7
}

class Batch(val id: String) {
    val problems = observableListOf<Problem>()
    var wins = 0
    var totalGuesses = 0
    fun add(problem: Problem) {
        if (problem.win) wins += 1
        totalGuesses += problem.size
    }
}

class FirstSolverModel(val dataset: Dataset) : Reporter {

    val needsPreparing = SimpleBooleanProperty(true)
    val batches = observableListOf<Batch>()
    val problems = observableListOf<Problem>()

    val firstGuess = SimpleStringProperty("VALOR")
    val solver = FirstSolver(dataset, firstGuess.value)

    val guesses = mutableListOf<String>()

    var batchInProgress = Batch("N/A")

    fun prepare() {
        solver.prepare()
        needsPreparing.set(false)
    }

    fun run2315() {
        val runner = Runner(this)
        solver.first = firstGuess.value
        task {
            runner.run(solver, dataset)
        }
    }

    override fun startBatch(id: String) {
        batchInProgress = Batch(id)
    }

    override fun endBatch() {
        runLater {
            batches.add(batchInProgress)
        }
    }

    override fun startRun(id: String) {
        guesses.clear()
    }

    override fun guess(guess: String, result: String) {
        guesses += guess
    }

    override fun endRun(answer: String) {
        val problem = Problem(answer, guesses)
        batchInProgress.add(problem)
    }

    fun runSolutions() {
        for (solution in dataset.solutions) {
            firstGuess.value = solution
            run2315()
        }
    }
}