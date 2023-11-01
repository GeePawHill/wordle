package org.geepawhill.wordle

import javafx.beans.property.SimpleBooleanProperty
import tornadofx.*

class MaxInfoModel(val dataset: Dataset) : Reporter, BatchModel {

    val needsPreparing = SimpleBooleanProperty(true)
    override val batches = observableListOf<Batch>()

    val solver = MaxInfoSolver(dataset)

    val guesses = mutableListOf<String>()

    var batchId = "N/A"
    var problems = observableListOf<Problem>()
    var totalRuns = 0
    var totalGuesses = 0
    var totalLosses = 0

    fun prepare() {
        solver.prepare()
        needsPreparing.set(false)
    }

    fun run2315() {
        val runner = Runner(this)
        task {
            runner.run(solver, dataset)
        }
    }

    override fun startBatch(id: String) {
        batchId = id
        totalRuns = 0
        totalGuesses = 0
        totalLosses = 0
        problems = observableListOf()
    }

    override fun endBatch() {
        val batch = Batch(batchId, totalGuesses.toDouble() / totalRuns.toDouble(), totalLosses, problems)
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
        if (!problem.win) totalLosses += 1
        problems.add(problem)
    }
}