package org.geepawhill.wordle

class MaxInfoSolver(val dataset: Dataset) : Solver {

    var guessNumber = 0
    val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    val unused = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    val guesses = listOf("RAISE", "JUMPY", "OFLAG", "BLUDE")
    val fullMap: MutableMap<String, EnyMap> = mutableMapOf();
    var lastGuess = guesses[0]
    var lastSolution: Set<String> = dataset.solutions

    override fun prepare() {
        if (fullMap.isEmpty()) {
            for (guess in dataset.combined) {
                fullMap[guess] = EnyMap.makeEnyMap(guess, dataset.solutions)
            }
        }
        lastGuess = first()
        lastSolution = dataset.solutions
        guessNumber = 0
    }

    override fun first(): String {
        lastSolution = dataset.solutions
        lastGuess = guesses[0]
        guessNumber = 0
        return lastGuess
    }

    override fun next(eny: String): String {
        val new = fullMap[lastGuess]!!.map[eny]!!
        lastSolution = lastSolution.intersect(new)
        guessNumber += 1
        if (lastSolution.size == 1) lastGuess = lastSolution.first()
        else {
            if (guessNumber > 3) {
                lastGuess = lastSolution.random()
            } else lastGuess = guesses[guessNumber]
        }
        return lastGuess
    }

    override fun id(): String {
        return first()
    }

}