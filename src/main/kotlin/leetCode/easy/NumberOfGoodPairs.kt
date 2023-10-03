package leetCode.easy

class NumberOfGoodPairs {
    fun numIdenticalPairs(nums: IntArray): Int {
        val frequencies = mutableMapOf<Int, Int>()

        var count = 0
        for (num in nums) {
            val newValue = frequencies.getOrDefault(num, 0) + 1
            frequencies[num] = newValue
            if (newValue > 1) {
                count += newValue - 1
            }
        }

        return count
    }
}

fun main(args: Array<String>) {
    val solution = NumberOfGoodPairs()
}