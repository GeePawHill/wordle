package org.geepawhill.wordle

interface Solver {
    fun prepare()
    fun first(): String

    fun lose()

    fun win()
}