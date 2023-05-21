package leetCode.easy

class ThirdMaximumNumber {
    fun thirdMax(nums: IntArray): Int {
        var firstMax: Int? = null
        var secondMax: Int? = null
        var thirdMax: Int? = null
        for (i in nums.indices) {
            if (nums[i] == thirdMax || nums[i] == secondMax || nums[i] == firstMax) {
                continue
            }

            if (firstMax == null || firstMax < nums[i]) {
                thirdMax = secondMax
                secondMax = firstMax
                firstMax = nums[i]
            } else if (secondMax == null || secondMax < nums[i]) {
                thirdMax = secondMax
                secondMax = nums[i]
            } else if (thirdMax == null || thirdMax < nums[i]) {
                thirdMax = nums[i]
            }
        }
        return if (thirdMax == null && firstMax != null) {
            firstMax
        } else thirdMax ?: throw RuntimeException("Unsupported case")
    }
}

fun main(args: Array<String>) {
    val result = intArrayOf(3, 2, 1)
    println(ThirdMaximumNumber().thirdMax(result))
}