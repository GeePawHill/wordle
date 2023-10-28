package org.geepawhill.wordle

import org.junit.jupiter.api.Test

class FirstSolverTest {
    val dataset = Dataset()
    val reporter = Reporter()

    @Test
    fun `run on all`() {
        val solver = FirstSolver(dataset, "SAOLA")
        val runner = Runner(reporter)
        runner.run(solver, dataset)
    }

    @Test
    fun `run on one`() {
        val solver = FirstSolver(dataset, "SAOLA")
        val runner = Runner(reporter)
        dataset.solutions.forEach {
            runner.run(solver, it)
        }
        reporter.endBatch()
    }
}