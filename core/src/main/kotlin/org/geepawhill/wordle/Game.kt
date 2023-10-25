package org.geepawhill.wordle

typealias Eny = String

class Game {

    companion object {
        fun scoreNaive(answer: String, guess: String): Eny {
            val upper = guess.uppercase()
            val indexed = upper.withIndex()
            var result = Eny()
            indexed.forEach { item ->
                if (upper[item.index] == answer[item.index]) result += 'E'
                else if (answer.contains(upper[item.index])) result += 'Y'
                else result += 'N'
            }
            return result
        }

        fun scoreStrict(answer: String, guess: String): Eny {
            val upper = guess.uppercase()
            val indexed = upper.withIndex()
            val result = mutableListOf('N', 'N', 'N', 'N', 'N')
            val pool = answer.toMutableList()
            indexed.forEach { item ->
                if (upper[item.index] == answer[item.index]) {
                    result[item.index] = 'E'
                    pool.remove(upper[item.index])
                }
            }
            indexed.forEach { item ->
                if (result[item.index] != 'E') {
                    if (pool.contains(upper[item.index])) {
                        pool.remove(upper[item.index])
                        result[item.index] = 'Y'
                    } else {
                        result[item.index] = 'N'
                    }
                }
            }
            return result.joinToString("")
        }
    }
}