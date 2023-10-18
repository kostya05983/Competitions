package leetCode.easy

class BinaryPrefixDivisibleBy5 {
    fun prefixesDivBy5(nums: IntArray): List<Boolean> {
        var number = 0

        val result = BooleanArray(nums.size) { false }
        for (i in nums.indices) {
            number = (number * 2 + nums[i]).rem(5)

            result[i] = number == 0
        }

        return result.toList()
    }
}

fun main(args: Array<String>) {
    val solution = BinaryPrefixDivisibleBy5()
    println(solution.prefixesDivBy5(intArrayOf(0, 1, 1)))
}