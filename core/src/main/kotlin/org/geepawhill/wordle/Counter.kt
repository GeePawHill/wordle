package org.geepawhill.wordle

private const val ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

class Counter {

    val anywhere = mutableMapOf<Char, Int>()
    val positions = listOf(
        mutableMapOf<Char, Int>(),
        mutableMapOf<Char, Int>(),
        mutableMapOf<Char, Int>(),
        mutableMapOf<Char, Int>(),
        mutableMapOf<Char, Int>(),
    )

    init {
        reset()
    }

    private fun reset() {
        for (c in ALPHABET) {
            anywhere[c] = 0
            for (position in 0 until 5) positions[position][c] = 0
        }
    }

    fun count(word: String) {
        val upper = word.uppercase()
        val indexed = upper.withIndex()
        for (index in indexed) {
            anywhere[index.value] = anywhere[index.value]!! + 1
            positions[index.index][index.value] = positions[index.index][index.value]!! + 1
        }
    }

    fun count(vararg words: String) {
        for (word in words) count(word)
    }


    fun count(words: Collection<String>) {
        for (word in words) count(word)
    }

    operator fun get(letter: String): Int = get(letter[0])

    operator fun get(letter: Char): Int {
        return anywhere[letter]!!
    }

    fun sortedAnywhere(): List<Frequency> {
        val counts = mutableListOf<Frequency>()
        for (letter in ALPHABET) {
            counts += Frequency(letter, get(letter)!!)
        }
        counts.sortByDescending { it.count }
        return counts
    }

    fun sortedPositional(position: Int): List<Frequency> {
        val counts = mutableListOf<Frequency>()
        for (letter in ALPHABET) {
            counts += Frequency(letter, positions[position].get(letter)!!)
        }
        counts.sortByDescending { it.count }
        return counts
    }
}