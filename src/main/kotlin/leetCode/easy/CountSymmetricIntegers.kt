package leetCode.easy

import org.junit.jupiter.api.Assertions.assertEquals

class CountSymmetricIntegers {
    fun countSymmetricIntegers(low: Int, high: Int): Int {
        var count = 0
        for (i in low..high) {
            if (isSymmetric(i)) {
                count++
            }
        }

        return count
    }

    private fun isSymmetric(num: Int): Boolean {
        val result = mutableListOf<Int>()
        var remain = num
        while (remain > 0) {
            result.add(remain.rem(10))
            remain /= 10
        }

        if (result.size.rem(2) != 0) return false

        return result.subList(0, result.size / 2).sum() == result.subList(result.size / 2, result.size).sum()
    }
}

fun main(args: Array<String>) {
    val solution = CountSymmetricIntegers()

    val example1 = solution.countSymmetricIntegers(1, 100)
    assertEquals(9, example1)

    val example2 = solution.countSymmetricIntegers(1200, 1230)
    assertEquals(4, example2)
}