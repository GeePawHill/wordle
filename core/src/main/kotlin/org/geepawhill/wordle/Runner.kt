package org.geepawhill.wordle

class Runner {

    fun run(solver: Solver, answer: String) {
        solver.prepare()
        var guess = solver.first()
        for (attempt in 0 until 7) {
            val result = Game.scoreStrict(answer, guess)
            if (result == "EEEEE") break
            guess = solver.next(result)
        }
    }
}