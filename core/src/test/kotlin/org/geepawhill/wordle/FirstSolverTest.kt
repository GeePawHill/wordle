package org.geepawhill.wordle

import org.junit.jupiter.api.Test

class FirstSolverTest {
    val dataset = Dataset()
    val reporter = ConsoleSummary()

    @Test
    fun `run on all`() {
        val solver = FirstSolver(dataset, "SALET")
        solver.prepare()
        val runner = Runner(reporter)
        var startTime = System.nanoTime()
        runner.run(solver, dataset)
        println((System.nanoTime() - startTime) / 1000000.0)
        solver.first = "RUGBY"
        startTime = System.nanoTime()
        runner.run(solver, dataset)
        println((System.nanoTime() - startTime) / 1000000.0)
    }
}