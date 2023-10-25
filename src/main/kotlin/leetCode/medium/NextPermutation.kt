package leetCode.medium

class NextPermutation {
    fun nextPermutation(nums: IntArray): Unit {
        var previous = nums[0]
        for (i in nums.size - 1 downTo 0) {
            val temp = previous
            nums[i] = previous
            previous = temp
        }
        println(nums.toList())
    }
}

fun main(args: Array<String>) {
    val solution = NextPermutation()
    println(solution.nextPermutation(intArrayOf(1, 2, 3)))
    println(solution.nextPermutation(intArrayOf(3, 2, 1)))
    println(solution.nextPermutation(intArrayOf(1, 1, 5)))
}