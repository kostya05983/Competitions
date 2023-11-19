package leetCode.medium

import java.util.Collections
import java.util.PriorityQueue
import java.util.TreeMap

class SeparateBlackAndWhiteBalls {
    fun minimumSteps(s: String): Long {
        val rightPositions = PriorityQueue<Int>(Collections.reverseOrder())
        for (i in s.indices) {
            val ch = s[i]
            if (ch == '1') {
                rightPositions.add(i)
            }
        }

        var right = s.length - 1
        var count = 0L
        while (rightPositions.isNotEmpty()) {
            val popped = rightPositions.poll()

            if (popped != right) {
                count += right - popped
            }
            right--
        }

        return count
    }
}

fun main(args: Array<String>) {
    val solution = SeparateBlackAndWhiteBalls()
    println(solution.minimumSteps("101"))
    println(solution.minimumSteps("100"))
    println(solution.minimumSteps("0111"))
}