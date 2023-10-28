package org.geepawhill.wordle

import org.junit.jupiter.api.Test

class FirstSolverTest {
    val dataset = Dataset()
    val reporter = ConsoleReporter()

    @Test
    fun `run on all`() {
        val solver = FirstSolver(dataset, "RUGBY")
        val runner = Runner(reporter)
        runner.run(solver, dataset)
        solver.first = "SOLAR"
        runner.run(solver, dataset)
    }
}