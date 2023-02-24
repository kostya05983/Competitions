package leetCode.medium

import kotlin.math.pow

class GrayCode {
    fun grayCode(n: Int): List<Int> {
        val elementCount = 2.0.pow(n).toInt()

        val result = ArrayList<Int>(elementCount)
        result.add(0)
        result.add(1)

        for (i in 1 until n) {
            var j = result.size - 1
            while (j >= 0) {
                val remain = result[j]
                result.add(ONE.shl(i) + remain)
                j--
            }
        }
        return result
    }

    private companion object {
        const val ONE = 1
    }
}

fun main(args: Array<String>) {
    val solution = GrayCode()
    val test1 = solution.grayCode(2)
    require(test1[0] == 0)
    require(test1[1] == 1)
    require(test1[2] == 3)
    require(test1[3] == 2)

    val test2 = solution.grayCode(1)
    require(test2[0] == 0)
    require(test2[1] == 1)
}