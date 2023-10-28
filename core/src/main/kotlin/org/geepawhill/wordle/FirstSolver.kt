package org.geepawhill.wordle

class FirstSolver(val dataset: Dataset, val first: String) : Solver {

    val fullMap: MutableMap<String, EnyMap> = mutableMapOf();
    var lastGuess = first
    var lastSolution: Set<String> = dataset.solutions

    override fun prepare() {
        if (fullMap.isEmpty()) {
            for (guess in dataset.combined) {
                fullMap[guess] = EnyMap.makeEnyMap(guess, dataset.solutions)
            }
        }
        lastGuess = first()
        lastSolution = dataset.solutions
    }

    override fun first(): String {
        lastSolution = dataset.solutions
        lastGuess = first
        return first
    }

    override fun next(eny: String): String {
        if (eny == "NNNNN") return first
        val new = fullMap[lastGuess]!!.map[eny]!!
        lastSolution = lastSolution.intersect(new)
        lastGuess = lastSolution.first()
        return lastGuess
    }

}