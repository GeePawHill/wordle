package org.geepawhill.wordle

class EnyMap {
    val map = mutableMapOf<String, MutableList<String>>()

    fun add(eny: Eny, answer: String) {
        val list = map.getOrDefault(eny, mutableListOf())
        list.add(answer)
        map[eny] = list
    }

    fun pick(eny: String): String {
        val list = map.getOrDefault(eny, mutableListOf("ZZZZZ"))
        return list[0]
    }

    companion object {
        fun makeEnyMap(guess: String, answers: List<String>): EnyMap {
            val map = EnyMap()
            for (answer in answers) {
                val result = Game.scoreStrict(answer, guess)
                map.add(result, answer)
            }
            return map
        }
    }
}