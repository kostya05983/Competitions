package leetCode.easy

import org.junit.jupiter.api.Assertions.assertEquals

class DetectPatternOfLengthMRepeated {

    fun containsPattern(arr: IntArray, m: Int, k: Int): Boolean {
        val buffer = IntArray(m)
        for (i in 0 .. arr.size - m * k) {
            for (j in i until i + m) {
                buffer[j - i] = arr[j]
            }

            val left = i + m
            val right = left + (k - 1) * m
            if (check(left, right, arr, buffer)) return true
        }

        return false
    }

    private fun check(left: Int, right: Int, arr: IntArray, buffer: IntArray): Boolean {
        for (j in left until right) {
            if (arr[j] != buffer[(j - left).rem(buffer.size)]) return false
        }
        return true
    }
}

fun main(args: Array<String>) {
    val solution = DetectPatternOfLengthMRepeated()
    val example1 = solution.containsPattern(intArrayOf(1, 2, 4, 4, 4, 4), 1, 3)
    assertEquals(true, example1)

    val example2 = solution.containsPattern(intArrayOf(1, 2, 1, 2, 1, 1, 1, 3), 2, 2)
    assertEquals(true, example2)

    val example3 = solution.containsPattern(intArrayOf(1, 2, 1, 2, 1, 3), 2, 3)
    assertEquals(false, example3)
}