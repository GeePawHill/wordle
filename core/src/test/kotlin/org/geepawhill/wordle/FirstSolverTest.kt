package org.geepawhill.wordle

import org.junit.jupiter.api.Test

class FirstSolverTest {
    val dataset = Dataset()
    val reporter = Reporter()

    @Test
    fun `run on all`() {
        val solver = FirstSolver(dataset, "TALER")
        val runner = Runner(reporter)
        runner.run(solver, dataset)
    }
}