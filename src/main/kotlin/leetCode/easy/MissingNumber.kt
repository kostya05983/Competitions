package leetCode.easy

class MissingNumber {
    fun missingNumber(nums: IntArray): Int {
        val set = nums.toSet()
        val n = nums.size + 1

        var i = 0
        while (i != n) {
            if (!set.contains(i)) return i
            i++
        }

        return 0
    }
}

fun main(args: Array<String>) {
    println(MissingNumber().missingNumber(intArrayOf(3, 0, 1)))
    println(MissingNumber().missingNumber(intArrayOf(0, 1)))
    println(MissingNumber().missingNumber(intArrayOf(9, 6, 4, 2, 3, 5, 7, 0, 1)))
}