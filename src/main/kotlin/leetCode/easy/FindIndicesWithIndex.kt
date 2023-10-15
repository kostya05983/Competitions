package leetCode.easy

import java.util.TreeMap
import kotlin.math.abs
import kotlin.math.min

class FindIndicesWithIndex {
    fun findIndices(nums: IntArray, indexDifference: Int, valueDifference: Int): IntArray {
        for (i in nums.indices) {
            for (j in nums.indices) {
                if (abs(i - j) >= indexDifference && abs(nums[i] - nums[j]) >= valueDifference) return intArrayOf(i, j)
            }
        }

        return intArrayOf(-1, -1)
    }

    fun findIndices2(nums: IntArray, indexDifference: Int, valueDifference: Int): IntArray {
        val map = TreeMap<Int, List<Int>>()

        for (i in nums.indices) {
            map[nums[i]] = map.getOrDefault(nums[i], emptyList()) + listOf(i)
        }

        for (i in nums.indices) {
            val searchAdd = valueDifference + nums[i]

            var addFound = map.ceilingEntry(searchAdd)

            var internalIndex = 0

            while (addFound != null && abs(i - addFound.value[internalIndex]) < indexDifference) {
                if (internalIndex < addFound.value.size - 1) {
                    internalIndex++
                    continue
                } else {
                    internalIndex = 0
                    addFound = map.ceilingEntry(addFound.key + 1) ?: break
                }
            }

            if (addFound != null && abs(i - addFound.value[internalIndex]) >= indexDifference) {
                return intArrayOf(i, addFound.value[internalIndex])
            }
        }

        return intArrayOf(-1, -1)
    }
}

fun main(args: Array<String>) {
    val solution = FindIndicesWithIndex()
//    println(solution.findIndices2(intArrayOf(5, 1, 3, 1), 2, 4).toList())
//    println(solution.findIndices2(intArrayOf(2, 1), 0, 0).toList())
//    println(solution.findIndices2(intArrayOf(1, 2, 3), 2, 4).toList())
//    println(solution.findIndices2(intArrayOf(9, 5, 4), 1, 0).toList())
//    println(solution.findIndices2(intArrayOf(7), 0, 0).toList())
//    println(solution.findIndices2(intArrayOf(9, 4, 0, 9), 2, 1).toList())
//    println(solution.findIndices2(intArrayOf(9, 4, 0, 0), 2, 1).toList())
    println(solution.findIndices2(intArrayOf(9, 1, 0, 4, 3, 3), 4, 3).toList())
}