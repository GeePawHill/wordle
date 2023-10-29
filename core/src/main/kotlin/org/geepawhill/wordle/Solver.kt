package org.geepawhill.wordle

interface Solver {
    fun prepare()
    fun first(): String
    fun next(eny: String): String

    fun id(): String
}