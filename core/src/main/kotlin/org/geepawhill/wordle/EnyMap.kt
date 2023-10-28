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
        fun makeEnyMap(guess: String, solutions: Set<String>): EnyMap {
            val map = EnyMap()
            for (solution in solutions) {
                val eny = Game.scoreStrict(solution, guess)
                if (eny.equals("EEEEE")) continue
                map.add(eny, solution)
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