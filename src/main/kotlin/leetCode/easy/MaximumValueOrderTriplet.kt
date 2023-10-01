package leetCode.easy

import java.util.LinkedList

class MaximumValueOrderTriplet {
    fun maximumTripletValue(nums: IntArray): Long {
        var max = 0L
        for (i in 0 until nums.size) {
            for (j in i + 1 until nums.size) {
                for (k in j + 1 until nums.size) {
                    max = maxOf(max, (nums[i] - nums[j]) * nums[k].toLong())
                }
            }
        }

        return max
    }
}

fun main(args: Array<String>) {
    val solution = MaximumValueOrderTriplet()
    solution.maximumTripletValue(intArrayOf(12, 6, 1, 2, 7))
}