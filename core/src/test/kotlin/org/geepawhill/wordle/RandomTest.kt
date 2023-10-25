package org.geepawhill.wordle

import org.junit.jupiter.api.Test

class RandomTest {
    @Test
    fun `Dataset frequency count`() {
        val set = Dataset()
        val counter = Counter()
        counter.count(set.combined)
        val counts = counter.sortedAnywhere()
        for (count in counts) {
            println("${count.letter}: ${count.count}")
        }
    }

    @Test
    fun `positional frequency count`() {
        val set = Dataset()
        val counter = Counter()
        counter.count(set.combined)
        dumpPosition(counter.sortedPositional(0), 0)
        dumpPosition(counter.sortedPositional(1), 1)
        dumpPosition(counter.sortedPositional(2), 2)
        dumpPosition(counter.sortedPositional(3), 3)
        dumpPosition(counter.sortedPositional(4), 4)
    }

    private fun dumpPosition(source: List<Frequency>, position: Int) {
        println("Positon $position")
        println("---------")
        for (count in source) {
            println("${count.letter}: ${count.count}")
        }
    }
}