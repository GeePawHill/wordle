package org.geepawhill.wordle

interface Reporter {
    fun startBatch(id: String, elapsed: NanoSeconds)
    fun endBatch()
    fun startRun()
    fun guess(guess: String, result: String)
    fun endRun(answer: String, elapsed: NanoSeconds)
}