package leetCode.easy

import kotlin.math.abs

class MaximumStrongPairXor {
    fun maximumStrongPairXor(nums: IntArray): Int {
        var maxXor = 0

        for (i in nums.indices) {
            for (j in nums.indices) {
                val diff = abs(nums[i] - nums[j])
                val min = minOf(nums[i], nums[j])
                if (diff <= min) {
                    maxXor = maxOf(nums[i].xor(nums[j]), maxXor)
                }
            }
        }

        return maxXor
    }
}

fun main(args: Array<String>) {
    val solution = MaximumStrongPairXor()
    println(solution.maximumStrongPairXor(intArrayOf(1, 2, 3, 4, 5)))
    println(solution.maximumStrongPairXor(intArrayOf(10, 100)))
    println(solution.maximumStrongPairXor(intArrayOf(5, 6, 25, 30)))
}