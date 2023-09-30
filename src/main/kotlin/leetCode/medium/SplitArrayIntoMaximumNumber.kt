package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis

class SplitArrayIntoMaximumNumber {
    fun maxSubarrays(nums: IntArray): Int {
        //идём дальше, набираем подмассив
        //делим подмассив и идём дальше набирать новый
        //стейт, мы знаем текущую сумму подмасива через and оператор
        //стейт, мы знаем число подмассивов, т.к если разделили, то это +1
        //стейт,
        return handle(nums[0], 0, 1, 1, nums, mutableMapOf(), IntArray(1) { Int.MAX_VALUE }).second
    }

    private fun handle(
        subArraySum: Int,
        sum: Int,
        subArrayCount: Int,
        index: Int,
        nums: IntArray,
        memory: MutableMap<Pair<Int, Int>, Pair<Int, Int>>,
        memory2: IntArray
    ): Pair<Int, Int> {
        if (index == nums.size) {
            return sum + subArraySum to subArrayCount //завершаем массив
        }

        if (memory2[0] < (sum + subArraySum)) return Pair(Int.MAX_VALUE, Int.MIN_VALUE)

        val moveNext = handle(subArraySum.and(nums[index]), sum, subArrayCount, index + 1, nums, memory, memory2)

        val memorized = memory[Pair(subArrayCount, index)]
        val devideNext = if (memorized != null) {
            memorized
        } else {
            val result = handle(nums[index], sum + subArraySum, subArrayCount + 1, index + 1, nums, memory, memory2)
//            memory[Pair(subArrayCount, index)] = result
            result
        }

        return when {
            moveNext.first < devideNext.first -> {
                memory2[0] = minOf(moveNext.first, memory2[0])
                return moveNext
            }

            moveNext.first > devideNext.first -> {
                memory2[0] = minOf(devideNext.first, memory2[0])
                return devideNext
            }

            else -> {
                memory2[0] = minOf(moveNext.first, memory2[0])
                if (moveNext.second >= devideNext.second) {
                    return moveNext
                } else {
                    devideNext
                }
            }
        }
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