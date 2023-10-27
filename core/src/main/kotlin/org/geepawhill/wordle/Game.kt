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
            val result = mutableListOf('N', 'N', 'N', 'N', 'N')
            val pool = answer.toMutableList()
            for (item in 0 until 5) {
                if (guess[item] == answer[item]) {
                    result[item] = 'E'
                    pool.remove(answer[item])
                }
            }
            for (item in 0 until 5) {
                if (result[item] != 'E') {
                    if (pool.contains(guess[item])) {
                        pool.remove(guess[item])
                        result[item] = 'Y'
                    }
                }
            }
            val eny = result.joinToString("")
//            println("$answer : $guess -> $eny")
            return eny
        }
    }
}