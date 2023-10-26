package org.geepawhill.wordle

typealias NanoSeconds = Long

class Reporter {

    val guesses = mutableListOf<String>()

    fun startBatch(id: String, elapsed: NanoSeconds) {
        println("$id batch, $elapsed")
    }

    fun startRun() {
        guesses.clear()
    }

    fun guess(guess: String, result: String) {
        guesses += guess
    }

    fun endRun(answer: String, elapsed: NanoSeconds) {
        println("Run Over: [$answer] ${guesses.size} ${guesses.joinToString(" ")} ns:$elapsed ")
    }
}