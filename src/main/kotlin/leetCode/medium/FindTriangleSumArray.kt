package leetCode.medium

class FindTriangleSumArray {
    fun triangularSum(nums: IntArray): Int {
        var left = 0
        var offset = 0
        var previous = nums[0]
        while (left < nums.size - 1) {
            val temp = nums[left + 1]
            nums[left + 1] = (previous + nums[left + 1]).rem(10)
            previous = temp

            if (left == nums.size - 2) {
                offset++
                left = offset
                previous = nums[left]
                continue
            }
            left++
        }

        return nums.last()
    }
}

fun main(args: Array<String>) {
    val solution = FindTriangleSumArray()
    println(solution.triangularSum(intArrayOf(1, 2, 3, 4, 5)))
    println(solution.triangularSum(intArrayOf(5)))
    println(solution.triangularSum(intArrayOf(1, 2, 3, 4)))
}