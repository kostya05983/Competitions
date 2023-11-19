package leetCode.medium

class ReductionOperationsToMakeArrayEqual {
    fun reductionOperations(nums: IntArray): Int {
        nums.sort()

        var plusFactor = 0
        var prev = nums[0]

        var count = 0
        for (i in 1 until nums.size) {
            if (prev != nums[i]) {
                prev = nums[i]
                plusFactor++
            }
            count += plusFactor
        }

        return count
    }
}

fun main(args: Array<String>) {
    val solution = ReductionOperationsToMakeArrayEqual()
    println(solution.reductionOperations(intArrayOf(5, 1, 3)))
    println(solution.reductionOperations(intArrayOf(1, 1, 1)))
    println(solution.reductionOperations(intArrayOf(1, 1, 2, 2, 3)))
}