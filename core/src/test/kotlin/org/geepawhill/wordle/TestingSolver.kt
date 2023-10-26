package org.geepawhill.wordle

class TestingSolver(val guesses: List<String>) : Solver {


    constructor(vararg guesses: String) : this(guesses.toList())

    var next: Int = 1

    override fun prepare() {
        next = 1
    }

    override fun first(): String {
        return guesses[0]
    }

    override fun next(eny: String): String {
        return guesses[next++]
    }
}