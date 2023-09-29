package leetCode.easy

class BinarySearch {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        while (left <= right) {
            val mid = left + (right - left) / 2
            val num = nums[mid]

            when {
                num == target -> {
                    return mid
                }

                num < target -> {
                    left = mid + 1
                }

                num > target -> {
                    right = mid - 1
                }
            }
        }

        return -1
    }
}