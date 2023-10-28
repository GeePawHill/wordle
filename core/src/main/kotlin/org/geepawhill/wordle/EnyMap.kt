package org.geepawhill.wordle

class EnyMap {
    val map = mutableMapOf<String, MutableList<String>>()
    var oneSolutionLists = 0

    fun add(eny: Eny, answer: String) {
        val list = map.getOrDefault(eny, mutableListOf())
        list.add(answer)
        map[eny] = list
    }

    fun pick(eny: String): String {
        val list = map.getOrElse(eny) {
            throw EmptyEnvMapItem(eny)
        }
        return list[0]
    }

    companion object {
        fun makeEnyMap(guess: String, answers: Set<String>): EnyMap {
            val map = EnyMap()
            for (answer in answers) {
                val result = Game.scoreStrict(answer, guess)
                if (result.equals("EEEEE")) continue
                if (result.equals("NNNNN")) continue
                map.add(result, answer)
            }
            //map.callOutOneSolution(guess)
            return map
        }
    }

    private fun callOutOneSolution(guess: String): Boolean {
        for (entry in map.entries) {
            if (entry.value.size == 1) {
                println("Guess|Eny $guess|${entry.key} has one solution: ${entry.value.get(0)}")
                oneSolutionLists += 1
                return true
            }
        }
        return false
    }
}