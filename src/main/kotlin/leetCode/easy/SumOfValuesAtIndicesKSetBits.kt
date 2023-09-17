package leetCode.easy

class SumOfValuesAtIndicesKSetBits {
    fun sumIndicesWithKSetBits(nums: List<Int>, k: Int): Int {
        var result = 0

        for (i in 0 until nums.size) {
            val countOnes = toBinary(i)

            if (countOnes == k) {
                result += nums[i]
            }
        }

        return result
    }

    private fun toBinary(num: Int): Int {
        var count = 0
        var current = num
        while (current > 0) {
            val remain = current.rem(2)
            if (remain == 1) count += 1

            current /= 2
        }

        return count
    }
}

fun main(args: Array<String>) {
    val solution = SumOfValuesAtIndicesKSetBits()
    val example1 = solution.sumIndicesWithKSetBits(listOf(5, 10, 1, 5, 2), 1)
    println(example1)

    val example2 = solution.sumIndicesWithKSetBits(listOf(4, 3, 2, 1), 2)
    println(example2)
}