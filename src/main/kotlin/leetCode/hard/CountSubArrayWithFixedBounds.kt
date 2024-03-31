package leetCode.hard

import java.util.TreeMap

class CountSubArrayWithFixedBounds {

    fun countSubarrays(nums: IntArray, minK: Int, maxK: Int): Long {
        val treeMap = TreeMap<Int, Int>()

        var right = 0
        var left = 0

        var result = 0L

        while (right < nums.size) {
            val num = nums[right]

            if (num < minK || num > maxK) {
                right++
                left = right
                treeMap.clear()
                continue
            }

            treeMap[num] = treeMap.getOrDefault(num, 0) + 1

            val maxEntry = treeMap.lastEntry()
            val minEntry = treeMap.firstEntry()

            if (minEntry.key == minK && maxEntry.key == maxK) {
                val nextMinMax = nextMinMax(nums, right, minEntry.key, maxEntry.key)

                while (left < nums.size) {
                    result += nextMinMax - right
                    val leftNum = nums[left]

                    treeMap[leftNum] = treeMap.getOrDefault(leftNum, 0) - 1

                    if (treeMap[leftNum] == 0) {
                        treeMap.remove(leftNum)
                    }

                    left++
                    if (treeMap[leftNum] == null && (leftNum == maxEntry.key || leftNum == minEntry.key)) {
                        break
                    }
                }
            }

            right++
        }

        return result
    }

    private fun nextMinMax(nums: IntArray, right: Int, minNum: Int, maxNum: Int): Int {
        var right = right
        while (right < nums.size) {
            val num = nums[right]

            if (num < minNum) {
                return right
            }
            if (num > maxNum) {
                return right
            }
            right++
        }

        return nums.size
    }
}

fun main(args: Array<String>) {
    val solution = CountSubArrayWithFixedBounds()

    println(
        solution.countSubarrays(
            intArrayOf(
                8121,
                8121,
                955792,
                925378,
                383928,
                673920,
                457030,
                925378,
                925378,
                925378,
                92893,
                456370,
                925378
            ), 8121, 925378
        )
    )
    println(solution.countSubarrays(intArrayOf(1, 3, 5, 2, 7, 5), 1, 5))
    println(solution.countSubarrays(intArrayOf(1, 1, 1, 1), 1, 1))
    println(
        solution.countSubarrays(
            intArrayOf(
                1,
                2,
                10,
                10,
                9,
                10,
                1,
                10,
                3,
                10,
                1,
                4,
                5,
                7,
                6
            ), 1, 10
        )
    )
    println(
        solution.countSubarrays(
            intArrayOf(
                934372,
                927845,
                479424,
                49441,
                17167,
                17167,
                65553,
                927845,
                17167,
                927845,
                17167,
                425106,
                17167,
                927845,
                17167,
                927845,
                251338,
                17167
            ),
            17167, 927845
        )
    )
}