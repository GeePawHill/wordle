package org.geepawhill.wordle

typealias NanoSeconds = Long

class ConsoleReporter : Reporter {

    val guesses = mutableListOf<String>()
    var totalRuns = 0
    var totalGuesses = 0
    var wins = 0
    var losses = 0

    override fun startBatch(id: String, elapsed: NanoSeconds) {
        totalRuns = 0
        totalGuesses = 0
        wins = 0
        losses = 0
    }

    override fun endBatch() {
        println("Win/Loss/Total $wins/$losses/${wins + losses}")
        println("Average path: " + totalGuesses.toDouble() / totalRuns.toDouble())
    }

    override fun startRun() {
        guesses.clear()
    }

    override fun guess(guess: String, result: String) {
        guesses += guess
    }

    override fun endRun(answer: String, elapsed: NanoSeconds) {
        totalGuesses += guesses.size
        totalRuns += 1
        if (guesses.size == 7) losses += 1
        else wins += 1
        println("[$answer] ${guesses.size} ${guesses.joinToString(" ")}")
    }
}