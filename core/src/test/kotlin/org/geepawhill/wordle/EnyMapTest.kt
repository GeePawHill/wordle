package org.geepawhill.wordle

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.geepawhill.wordle.Game.Companion.scoreCount
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Disabled
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

    @Disabled("Long")
    @Test
    fun `make all words on solutions`() {
        val dataset = Dataset()
        scoreCount = 0
        val start = System.nanoTime()
        val fullMap = mutableMapOf<String, EnyMap>()
        for (guess in dataset.combined) {
            fullMap.put(
                guess,
                EnyMap.makeEnyMap(guess, dataset.solutions)
            )
        }
        println((System.nanoTime() - start) / 1000000L)
        println(scoreCount)
        val enySizes = fullMap.map { it.value.map.size }
        println("Average enyMap size: " + enySizes.average())
        println("Maximum enyMap size: " + enySizes.max())
        println("Minimum enyMap size: " + enySizes.min())
        val sizes = mutableListOf<Int>()
        for (enyMap in fullMap.values) {
            for (list in enyMap.map.values) {
                sizes += list.size
            }
        }
        println("Average solution size: " + sizes.average())
        println("Maximum solution size: " + sizes.max())
        println("Minimum solution size: " + sizes.min())
    }
}