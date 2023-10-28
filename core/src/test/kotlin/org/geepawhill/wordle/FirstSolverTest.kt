package org.geepawhill.wordle

import org.junit.jupiter.api.Test

class FirstSolverTest {
    val dataset = Dataset()
    val reporter = Reporter()

    @Test
    fun `run on one`() {
        val solver = FirstSolver(dataset, "RATOS")
        val runner = Runner(reporter)
        var solutions = 0
        dataset.solutions.forEach {
            println(solutions++)
            runner.run(solver, it)
        }
    }
}