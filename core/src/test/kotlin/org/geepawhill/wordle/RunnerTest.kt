package org.geepawhill.wordle

import org.junit.jupiter.api.Test

class RunnerTest {
    val runner = Runner()

    @Test
    fun `halts on 8 guesses`() {
        runner.run(TestingSolver("CRATE", "CRATE", "CRATE", "CRATE", "CRATE", "CRATE", "CRATE", "CRATE"), "CRETE")
    }

    @Test
    fun `halts on first guess`() {
        runner.run(TestingSolver("CRETE"), "CRETE")
    }
}
