package org.geepawhill.wordle


class Runner(val reporter: Reporter) {

    fun run(solver: Solver, answer: String) {
        val batchStarted = System.nanoTime()
        solver.prepare()
        reporter.startBatch(solver.javaClass.simpleName, System.nanoTime() - batchStarted);
        val runStarted = System.nanoTime()
        reporter.startRun()
        var guess = solver.first()
        for (attempt in 0 until 7) {
            val result = Game.scoreStrict(answer, guess)
            reporter.guess(guess, result)
            if (result == "EEEEE") break
            guess = solver.next(result)
        }
        reporter.endRun(answer, System.nanoTime() - runStarted)
    }

    fun run(solver: Solver, dataset: Dataset) {
        val batchStarted = System.nanoTime()
        solver.prepare()
        reporter.startBatch(solver.javaClass.simpleName, System.nanoTime() - batchStarted);
        for (answer in dataset.solutions) {
            val runStarted = System.nanoTime()
            reporter.startRun()
            var guess = solver.first()
            for (attempt in 0 until 7) {
                val result = Game.scoreStrict(answer, guess)
                reporter.guess(guess, result)
                if (result == "EEEEE") break
                guess = solver.next(result)
            }
            reporter.endRun(answer, System.nanoTime() - runStarted)
        }
        reporter.endBatch()
    }
}