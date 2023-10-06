package leetCode.medium

class CountNicePairsInArray {
    fun countNicePairs(nums: IntArray): Int {
        var count = 0L

        for (i in nums.indices) {
            nums[i] = nums[i] - revertNum(nums[i])
        }

        val frequencies = HashMap<Int, Int>()
        for (num in nums) {
            val newValue = frequencies.getOrDefault(num, 0) + 1
            frequencies[num] = newValue
            if (newValue > 1) {
                count += newValue - 1
            }
        }

        return count.rem(1000000000 + 7).toInt()
    }

    private fun revertNum(it: Int): Int {
        var current = it

        var result = 0
        while (current > 0) {
            result = result * 10 + current.rem(10)
            current /= 10
        }

        return result
    }
}

fun main(args: Array<String>) {
    val solution = CountNicePairsInArray()
    solution.countNicePairs(intArrayOf(42, 11, 1, 97))
}