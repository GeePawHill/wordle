package org.geepawhill.wordle

import java.nio.file.Files
import java.nio.file.Path

class Dataset(val guessPath: Path, val solutionPath: Path) {

    val guesses: Set<String>
    val solutions: Set<String>
    val combined: Set<String>

    constructor() : this(DEFAULT_GUESS_PATH, DEFAULT_SOLUTION_PATH)

    init {
        guesses = Files.readAllLines(guessPath).map { it.uppercase() }.toSet()
        solutions = Files.readAllLines(solutionPath).map { it.uppercase() }.toSet()
        combined = guesses + solutions
    }

    companion object {
        val DEFAULT_GUESS_PATH: Path = Path.of("../data/valid_guesses.txt").toAbsolutePath().normalize()
        val DEFAULT_SOLUTION_PATH: Path = Path.of("../data/valid_solutions.txt").toAbsolutePath().normalize()
    }
}