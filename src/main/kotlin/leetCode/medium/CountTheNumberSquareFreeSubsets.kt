package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals

class CountTheNumberSquareFreeSubsets {
    fun squareFreeSubsets(nums: IntArray): Int {
        val hashSet = mutableSetOf<Int>()
        for (num in nums) {
            if (!hashSet.contains(num) && isSquareFree(num)) hashSet.add(num)
        }

        return 1.shl(hashSet.size) - 1

        //1) посчитать частотность square-free элементов
        //2) Из них составить все возможные подмножества, в которых произведение останется square-free
        //3) Учесть частотность элементов входящих в множество
    }

    private fun isSquareFree(num: Int): Boolean {
        if (num < 4) return true

        var i = 2
        while (true) {
            val remainder = num.rem(i)
            val digit = num / i
            if (remainder == 0 && digit.rem(i) == 0) {
                return false
            }
            if (digit < i) return true
            i++
        }
    }
}

fun main(args: Array<String>) {
    val solution = CountTheNumberSquareFreeSubsets()

    val example1 = solution.squareFreeSubsets(intArrayOf(3, 4, 4, 5))
    assertEquals(3, example1)

    val example2 = solution.squareFreeSubsets(intArrayOf(1))
    assertEquals(1, example2)

    val example3 = solution.squareFreeSubsets(intArrayOf(26, 6, 4, 27, 6, 18))
    assertEquals(3, example3)
}