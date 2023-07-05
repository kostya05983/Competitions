package leetCode.easy

import org.junit.jupiter.api.Assertions.assertEquals
import java.util.*
import kotlin.text.StringBuilder

class SplitWithMinimalSum {
    fun splitNum(num: Int): Int {
        val digits = PriorityQueue<Int>()
        var remaining = num

        while (remaining > 0) {
            digits.add(remaining.rem(10))
            remaining /= 10
        }

        val leftNum = StringBuilder()
        val rightNum = StringBuilder()

        while (digits.isNotEmpty()) {
            val min = digits.poll()
            if (digits.size.rem(2) == 0) {
                leftNum.append(min)
            } else {
                rightNum.append(min)
            }
        }

        return leftNum.toString().toInt() + rightNum.toString().toInt()
    }
}

fun main(args: Array<String>) {
    val solution = SplitWithMinimalSum()
    val example1 = solution.splitNum(4325)
    assertEquals(59, example1)

    val example2 = solution.splitNum(687)
    assertEquals(75, example2)
}