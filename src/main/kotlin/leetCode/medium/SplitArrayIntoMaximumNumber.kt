package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis

class SplitArrayIntoMaximumNumber {
    fun maxSubarrays(nums: IntArray): Int {
        var count = 0
        var current = Int.MAX_VALUE
        for (num in nums) {
            current = current.and(num)
            if (current == 0) {
                count++
                current = Int.MAX_VALUE
            }
        }

        return maxOf(1, count)
    }
}

fun main(args: Array<String>) {
    val solution = SplitArrayIntoMaximumNumber()
    val example1 = solution.maxSubarrays(intArrayOf(1, 0, 2, 0, 1, 2))
    println(example1)

    val example2 = solution.maxSubarrays(intArrayOf(5, 7, 1, 3))
    println(example2)

    val example3 = solution.maxSubarrays(intArrayOf(0, 0, 0, 0, 0))
    println(example3)

    val time = measureTimeMillis {
        solution.maxSubarrays(
            intArrayOf(
                0,
                0,
                148,
                29,
                116,
                148,
                135,
                37,
                91,
                113,
                130,
                65,
                33,
                15,
                0,
                7,
                91,
                101,
                28,
                44,
                0,
                69,
                110,
                97,
                0,
                0,
                0,
                50,
                119,
                0,
                147,
                113,
                82,
                67,
                51,
                0,
                132,
                58,
                0,
                146,
                94,
                137,
                0,
                0,
                0,
                127,
                0,
                0,
                77,
                0,
                0,
                0,
                0,
                97,
                0,
                25,
                30,
                117,
                127,
                0,
                82,
                68,
                0,
                1,
                126,
                129,
                11,
                79,
                79,
                0,
                117,
                132,
                0,
                0,
                0,
                32,
                19,
                31,
                71,
                17,
                32,
                0,
                51,
                21,
                43,
                18,
                123,
                0,
                114,
                0
            )
        )
    }
    println(time)

    val example4 = solution.maxSubarrays(intArrayOf(8, 10, 23, 26, 21, 28, 21, 14, 21, 14, 9, 16, 24, 29, 7, 26))
    assertEquals(4, example4)
}