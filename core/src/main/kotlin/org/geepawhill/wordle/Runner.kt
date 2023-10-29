package org.geepawhill.wordle


class Runner(val reporter: Reporter) {

    fun run(solver: Solver, answer: String) {
        solver.prepare()
        reporter.startBatch(solver.javaClass.simpleName);
        val runStarted = System.nanoTime()
        reporter.startRun(solver.id())
        var guess = solver.first()
        for (attempt in 0 until 7) {
            val result = Game.scoreStrict(answer, guess)
            reporter.guess(guess, result)
            if (result == "EEEEE") break
            guess = solver.next(result)
        }
        reporter.endRun(answer)
    }

    fun run(solver: Solver, dataset: Dataset) {
        solver.prepare()
        reporter.startBatch(solver.javaClass.simpleName);
        for (answer in dataset.solutions) {
            reporter.startRun(solver.id())
            var guess = solver.first()
            for (attempt in 0 until 7) {
                val result = Game.scoreStrict(answer, guess)
                reporter.guess(guess, result)
                if (result == "EEEEE") break
                guess = solver.next(result)
            }
            reporter.endRun(answer)
        }
        reporter.endBatch()
    }
}