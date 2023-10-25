package org.geepawhill.wordle

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CounterTest {

    val counter = Counter()

    @Test
    fun `counts five letters`() {
        counter.count("ABCDE")
        for (c in "ABCDE") {
            assertThat(counter[c]).isEqualTo(1)
        }
        for (c in "FGHIJKLMNOPQRSTUVWXYZ") {
            assertThat(counter[c]).isEqualTo(0)
        }
    }

    @Test
    fun `counts a set`() {
        counter.count("ABCDE", "ABFGH")
        for (c in "AB") assertThat(counter[c]).isEqualTo(2)
        for (c in "CDEFGH") {
            assertThat(counter[c]).isEqualTo(1)
        }
        for (c in "JKLMNOPQRSTUVWXYZ") {
            assertThat(counter[c]).isEqualTo(0)
        }
    }

    @Test
    fun `counts positionally`() {
        counter.count("ABCDE")
        val first = counter.sortedPositional(0)
        assertThat(first[0].letter).isEqualTo('A')
        assertThat(first[0].count).isEqualTo(1)
    }
}