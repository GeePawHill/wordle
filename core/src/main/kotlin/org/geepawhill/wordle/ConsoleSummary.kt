package org.geepawhill.wordle

class ConsoleSummary : Reporter {

    val guesses = mutableListOf<String>()
    var totalRuns = 0
    var totalGuesses = 0
    var wins = 0
    var losses = 0
    var id = "N/A"

    override fun startBatch(id: String) {
        totalRuns = 0
        totalGuesses = 0
        wins = 0
        losses = 0
    }

    override fun endBatch() {
        println("$id: $wins/$losses/${wins + losses}")
        println("Total Guesses: $totalGuesses")
        println("Average path: " + totalGuesses.toDouble() / totalRuns.toDouble())
    }

    override fun startRun(id: String) {
        this.id = id
        guesses.clear()
    }

    override fun guess(guess: String, result: String) {
        guesses += guess
    }

    override fun endRun(answer: String) {
        totalGuesses += guesses.size
        totalRuns += 1
        if (guesses.size == 7) losses += 1
        else wins += 1
    }
}