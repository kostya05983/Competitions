package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals

class PushDominoes {
    fun pushDominoes(dominoes: String): String {
        val forces = IntArray(dominoes.length)

        var force = 0
        for (i in dominoes.indices) {
            val ch = dominoes[i]

            force = when (ch) {
                'R' -> dominoes.length
                'L' -> 0
                else -> maxOf(force - 1, 0)
            }
            forces[i] += force
        }

        force = 0
        for (i in dominoes.length - 1 downTo 0) {
            val ch = dominoes[i]
            force = when (ch) {
                'R' -> 0
                'L' -> dominoes.length
                else -> maxOf(force - 1, 0)
            }
            forces[i] -= force
        }

        val sb = StringBuilder()

        for (force in forces) {
            if (force > 0) {
                sb.append('R')
            }
            if (force < 0) {
                sb.append("L")
            }
            if (force == 0) {
                sb.append(".")
            }
        }

        return sb.toString()
    }
}

fun main(args: Array<String>) {
    val solution = PushDominoes()
    val example1 = solution.pushDominoes("RR.L")
    assertEquals("RR.L", example1)

    val example2 = solution.pushDominoes(".L.R...LR..L..")
    assertEquals("LL.RR.LLRRLL..", example2)
}