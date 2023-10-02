package leetCode.medium

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue

class WinnerOfGame {
    fun winnerOfGame(colors: String): Boolean {
        var i = 0

        var aliceTurns = 0
        var bobTurns = 0
        while (i < colors.length - 2) {
            if (colors[i] == 'A' && colors[i + 1] == 'A' && colors[i + 2] == 'A') {
                aliceTurns++
            }

            if (colors[i] == 'B' && colors[i + 1] == 'B' && colors[i + 2] == 'B') {
                bobTurns++
            }

            i++
        }

        return aliceTurns - bobTurns >= 1
    }
}

fun main(args: Array<String>) {
    val solution = WinnerOfGame()
    val example1 = solution.winnerOfGame("AAABABB")
    assertTrue(example1)

    val example2 = solution.winnerOfGame("AA")
    assertFalse(example2)

    val example3 = solution.winnerOfGame("ABBBBBBBAAA")
    assertFalse(example3)
}