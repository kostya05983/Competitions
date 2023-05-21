package leetCode.easy

class RemoveDuplicates {
    fun removeDuplicates(nums: IntArray): Int {
        var currentSize = nums.size
        var i = 0
        while (i < currentSize - 1) {
            if (nums[i] == nums[i + 1]) {
                currentSize--
                leftShiftFrom(i, nums)
            }
            if (nums[i] != nums[i + 1]) {
                i++
            }
        }
        return currentSize
    }

    private fun leftShiftFrom(position: Int, nums: IntArray) {
        var current = position
        while (current < nums.size - 1) {
            nums[current] = nums[current + 1]
            current++
        }
    }
}

fun main(args: Array<String>) {
    val removeDuplicates = RemoveDuplicates()
    val result = intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)
    val size = removeDuplicates.removeDuplicates(result)
    println(size)
    println(result.toList())
}