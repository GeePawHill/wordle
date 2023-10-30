package org.geepawhill.wordle

import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.*

class Problem(val answer: String, guesses: List<String>) {
    val size = guesses.size
    val guessesString = guesses.joinToString(" ")
    val win = guesses.size < 7
}

class Batch(val id: String, val averagePath: Double) {
    val problems = observableListOf<Problem>()
    var losses = 0
    var totalGuesses = 0
    fun add(problem: Problem) {
        problems.add(problem)
        if (!problem.win) losses += 1
        totalGuesses += problem.size
    }
}

class FirstSolverModel(val dataset: Dataset) : Reporter {

    val needsPreparing = SimpleBooleanProperty(true)
    val batches = observableListOf<Batch>()

    val firstGuess = SimpleStringProperty("VALOR")
    val solver = FirstSolver(dataset, firstGuess.value)

    val guesses = mutableListOf<String>()

    var batchId = "N/A"
    val problems = mutableListOf<Problem>()
    var totalRuns = 0
    var totalGuesses = 0

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
        batchId = id
        totalRuns = 0
        totalGuesses = 0
        problems.clear()
    }

    override fun endBatch() {
        val batch = Batch(batchId, totalGuesses.toDouble() / totalRuns.toDouble())
        for (problem in problems) batch.add(problem)
        runLater {
            batches.add(batch)
        }
    }

    override fun startRun(id: String) {
        totalRuns += 1
        guesses.clear()
    }

    override fun guess(guess: String, result: String) {
        totalGuesses += 1
        guesses += guess
    }

    override fun endRun(answer: String) {
        val problem = Problem(answer, guesses)
        problems.add(problem)
    }

    fun runSolutions() {
        for (solution in dataset.solutions) {
            firstGuess.value = solution
            run2315()
        }
    }
}