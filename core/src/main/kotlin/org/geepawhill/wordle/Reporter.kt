package org.geepawhill.wordle

interface Reporter {
    fun startBatch(id: String)
    fun endBatch()
    fun startRun(id: String)
    fun guess(guess: String, result: String)
    fun endRun(answer: String)
}