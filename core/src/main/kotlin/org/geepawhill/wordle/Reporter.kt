package org.geepawhill.wordle

typealias NanoSeconds = Long

class Reporter {

    val guesses = mutableListOf<String>()
    var totalRuns = 0
    var totalGuesses = 0

    fun startBatch(id: String, elapsed: NanoSeconds) {
        totalRuns = 0
        totalGuesses = 0
    }

    fun endBatch() {
        println("Average path: " + totalGuesses.toDouble() / totalRuns.toDouble())
    }

    fun startRun() {
        guesses.clear()
    }

    fun guess(guess: String, result: String) {
        guesses += guess
    }

    fun endRun(answer: String, elapsed: NanoSeconds) {
        totalGuesses += guesses.size
        totalRuns += 1
        println("[$answer] ${guesses.size} ${guesses.joinToString(" ")}")
    }
}