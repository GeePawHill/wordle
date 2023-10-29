package org.geepawhill.wordle

import kotlin.random.Random

class FirstSolver(val dataset: Dataset, var first: String) : Solver {

    val fullMap: MutableMap<String, EnyMap> = mutableMapOf();
    var lastGuess = first
    var lastSolution: Set<String> = dataset.solutions

    var random = Random(0)

    override fun prepare() {
        if (fullMap.isEmpty()) {
            for (guess in dataset.combined) {
                fullMap[guess] = EnyMap.makeEnyMap(guess, dataset.solutions)
            }
        }
        lastGuess = first()
        lastSolution = dataset.solutions
        random = Random(0)
    }

    override fun first(): String {
        lastSolution = dataset.solutions
        lastGuess = first
        return first
    }

    override fun next(eny: String): String {
        val new = fullMap[lastGuess]!!.map[eny]!!
        lastSolution = lastSolution.intersect(new)
        lastGuess = lastSolution.random(random)
        return lastGuess
    }

    override fun id(): String {
        return first
    }

}