package org.geepawhill.wordle

import org.junit.jupiter.api.Test

class FirstSolverTest {
    val dataset = Dataset()
    val reporter = ConsoleSummary()

    @Test
    fun `run on all`() {
        val solver = FirstSolver(dataset, "RUGBY")
        solver.prepare()
        val startTime = System.nanoTime()
        val runner = Runner(reporter)
        runner.run(solver, dataset)
        println((System.nanoTime() - startTime) / 1000000.0)
        solver.first = "SOLAR"
        runner.run(solver, dataset)
    }
}