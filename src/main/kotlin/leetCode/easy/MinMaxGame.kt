package leetCode.easy

class MinMaxGame {
    fun minMaxGame(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]

        val half = nums.size / 2

        val result = IntArray(half)

        for (i in 0 until half) {
            if (i.rem(2) == 0) {
                result[i] = minOf(nums[2 * i], nums[2 * i + 1])
            } else {
                result[i] = maxOf(nums[2 * i], nums[2 * i + 1])
            }
        }

        return minMaxGame(result)
    }
}

fun main(args: Array<String>) {

}