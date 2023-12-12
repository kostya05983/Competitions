package leetCode.medium

class CountSubArrayWhereMaxAppears {
    fun countSubarrays(nums: IntArray, k: Int): Long {
        var left = 0
        var right = 0
        val max = nums.max()

        var maxCount = 0
        var result = 0L
        while (left < nums.size) {
            if (right < nums.size && nums[right] == max) {
                maxCount++
            }
            if (right >= nums.size && maxCount < k) {
                break
            }

            while (maxCount >= k) {
                result += (nums.size - right)
                if (nums[left] == max) {
                    maxCount--
                }
                left++
            }

            right++
        }

        return result
    }
}

fun main(args: Array<String>) {
    val solution = CountSubArrayWhereMaxAppears()
    println(solution.countSubarrays(intArrayOf(1, 3, 2, 3, 3), 2))
    println(solution.countSubarrays(intArrayOf(1, 4, 2, 1), 3))
}