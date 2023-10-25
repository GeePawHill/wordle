package org.geepawhill.wordle

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class DatasetTest {

    @Test
    fun loads() {
        val set = Dataset()
        assertThat(set.guesses.size).isEqualTo(10657)
        assertThat(set.solutions.size).isEqualTo(2315)
        assertThat(set.combined.size).isEqualTo(12972)
    }
}