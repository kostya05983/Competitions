package leetCode.easy

import org.junit.jupiter.api.Assertions.assertEquals

class CountBalls {
    fun countBalls(lowLimit: Int, highLimit: Int): Int {
        val boxes = mutableMapOf<Int, Int>()

        var max = 0
        for (i in lowLimit..highLimit) {
            val digitSum = getDigitSum(i)
            val new = boxes.getOrDefault(digitSum, 0) + 1
            boxes[digitSum] = new
            max = maxOf(max, new)
        }

        return max
    }

    private fun getDigitSum(i: Int): Int {
        var remain = i
        var sum = 0
        while (remain > 0) {
            sum += remain.rem(10)
            remain /= 10
        }

        return sum
    }
}

fun main(args: Array<String>) {
    val solution = CountBalls()

    val example1 = solution.countBalls(1, 10)
    assertEquals(2, example1)

    val example2 = solution.countBalls(5, 15)
    assertEquals(2, example2)

    val example3 = solution.countBalls(19, 28)
    assertEquals(2, example3)
}