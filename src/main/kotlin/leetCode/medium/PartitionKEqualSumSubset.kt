package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals

class PartitionKEqualSumSubset {
    fun canPartitionKSubsets(nums: IntArray, k: Int): Boolean {
        val sum = nums.sum()
        if (k <= 0 || sum.rem(k) != 0) return false
        val visited = IntArray(nums.size)

        return canPartition(nums, visited, 0, k, 0, 0, sum / k)
    }

    private fun canPartition(
        nums: IntArray,
        visited: IntArray,
        startIndex: Int,
        k: Int,
        sum: Int,
        amount: Int,
        target: Int
    ): Boolean {
        if (k == 1) return true
        if (sum == target && amount > 0) return canPartition(nums, visited, 0, k - 1, 0, 0, target)
        if (sum > target) return false

        for (i in startIndex until nums.size) {
            if (visited[i] == 0) {
                visited[i] = 1
                if (canPartition(nums, visited, i + 1, k, sum + nums[i], amount + 1, target)) return true
                visited[i] = 0
            }
        }

        return false
    }

}

fun main(args: Array<String>) {
    val solution = PartitionKEqualSumSubset()
    val example1 = solution.canPartitionKSubsets(intArrayOf(4, 3, 2, 3, 5, 2, 1), 4)
    assertEquals(true, example1)

    val example2 = solution.canPartitionKSubsets(intArrayOf(1, 2, 3, 4), 3)
    assertEquals(false, example2)

    val example3 = solution.canPartitionKSubsets(intArrayOf(1, 1, 1, 1, 2, 2, 2, 2), 2)
    assertEquals(true, example3)

//    (9+1+4)(2 +)(9 + 1 + 4)
    val example4 = solution.canPartitionKSubsets(intArrayOf(4, 4, 4, 6, 1, 2, 2, 9, 4, 6), 3)
    assertEquals(true, example4)

//    (1,2)(2)
    val example5 = solution.canPartitionKSubsets(intArrayOf(1, 2, 2, 2, 2), 3)
    assertEquals(false, example5)

    //7167 (5524, ) (383+4485+2299)
    val example6 = solution.canPartitionKSubsets(
        intArrayOf(
            730,
            580,
            401,
            659,
            5524,
            405,
            1601,
            3,
            383,
            4391,
            4485,
            1024,
            1175,
            1100,
            2299,
            3908
        ), 4
    )
    assertEquals(true, example6)

    val example7 = solution.canPartitionKSubsets(
        intArrayOf(1,2,3,5), 2
    )
    assertEquals(false, example7)
}