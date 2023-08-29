package leetCode.easy

import org.junit.jupiter.api.Assertions.assertEquals

class SubtractProductAndSumDigitsInteger {
    fun subtractProductAndSum(n: Int): Int {
        var remain = n
        var product = 1
        var sum = 0

        while (remain > 0) {
            val num = remain.rem(10)
            product *= num
            sum += num
            remain /= 10
        }

        return product - sum
    }
}

fun main(args: Array<String>) {
    val solution = SubtractProductAndSumDigitsInteger()

    val example1 = solution.subtractProductAndSum(234)
    assertEquals(15, example1)

    val example2 = solution.subtractProductAndSum(4421)
    assertEquals(21, example2)
}