package org.geepawhill.wordle

class Problem(val answer: String, guesses: List<String>) {
    val size = guesses.size
    val guessesString = guesses.joinToString(" ")
    val win = guesses.size < 7
}