package leetCode.easy

import org.junit.jupiter.api.Assertions.assertEquals

class MinLogOperations {
    fun minOperations(logs: Array<String>): Int {
        var deepCount = 0

        for (log in logs) {
            when (log) {
                "../" -> {
                    deepCount = maxOf(0, deepCount - 1)
                }

                "./" -> {
                }

                else -> {
                    deepCount++
                }
            }
        }

        return deepCount
    }
}

fun main(args: Array<String>) {
    val solution = MinLogOperations()
    val example1 = solution.minOperations(arrayOf("d1/", "d2/", "../", "d21/", "./"))
    assertEquals(2, example1)

    val example2 = solution.minOperations(arrayOf("d1/", "d2/", "./", "d3/", "../", "d31/"))
    assertEquals(3, example2)

    val example3 = solution.minOperations(arrayOf("d1/", "../", "../", "../"))
    assertEquals(0, example3)
}