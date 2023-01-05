package leetCode.easy

class SingleNumber {
    fun singleNumber(nums: IntArray): Int {
        var result = 0

        for (num in nums) {
            result = result xor num
        }

        return result
    }
}

fun main(args: Array<String>) {
    println(SingleNumber().singleNumber(intArrayOf(2, 2, 1)))
    println(SingleNumber().singleNumber(intArrayOf(4, 1, 2, 1, 2)))
    println(SingleNumber().singleNumber(intArrayOf(1)))
}