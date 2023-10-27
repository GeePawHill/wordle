package org.geepawhill.wordle

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class EnyMapTest {

    @Test
    fun `pick on empty map throws`() {
        val map = EnyMap.makeEnyMap("ABCDE", emptySet())
        assertThrows(EmptyEnvMapItem::class.java) {
            map.pick("YYYNN")
        }
    }

    @Test
    fun `make on list works`() {
        val map = EnyMap.makeEnyMap("ABCDE", setOf("ABCDF", "EDCBA"))
        System.out.println(map.map)
        assertThat(map.pick("EEEEN")).isEqualTo("ABCDF")
        assertThat(map.pick("YYEYY")).isEqualTo("EDCBA")
    }

    @Test
    fun `make all words on solutions`() {
        val dataset = Dataset()
        val start = System.nanoTime()
        for (guess in dataset.guesses) {
            EnyMap.makeEnyMap(guess, dataset.solutions)
        }
        println((System.nanoTime() - start) / 1000000L)
    }
}