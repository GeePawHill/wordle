package org.geepawhill.wordle

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GameTest {


    @Test
    fun `scores strictly`() {
        assertThat(Game.scoreStrict("AAAAA", "AAAAA")).isEqualTo("EEEEE")
        assertThat(Game.scoreStrict("AAAAA", "BBBBB")).isEqualTo("NNNNN")
        assertThat(Game.scoreStrict("ABCDE", "ABABA")).isEqualTo("EENNN")
        assertThat(Game.scoreStrict("EMAIL", "ELOPE")).isEqualTo("EYNNN")
        assertThat(Game.scoreStrict("CREDO", "CREED")).isEqualTo("EEENY")
        assertThat(Game.scoreStrict("CREED", "CREDO")).isEqualTo("EEEYN")
        assertThat(Game.scoreStrict("YYYAA", "XAXAX")).isEqualTo("NYNEN")
    }
}