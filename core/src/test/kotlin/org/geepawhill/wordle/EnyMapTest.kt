package org.geepawhill.wordle

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test

class EnyMapTest {

    @Test
    fun `empty map yields ZZZZZs`() {
        val map = EnyMap.makeEnyMap("ABCDE", emptyList())
        assertThat(map.pick("YYYNN")).isEqualTo("ZZZZZ")
    }
}