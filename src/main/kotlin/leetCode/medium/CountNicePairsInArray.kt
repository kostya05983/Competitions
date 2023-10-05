package leetCode.medium

class CountNicePairsInArray {
    fun countNicePairs(nums: IntArray): Int {
        var count = 0L

        val transformed = nums.asSequence().map {
            it - revertNum(it)
        }

        val frequencies = mutableMapOf<Int, Int>()

        for (transform in transformed) {
            val newValue = frequencies.getOrDefault(transform, 0) + 1
            frequencies[transform] = newValue
            if (newValue > 1) {
                count += newValue - 1
            }
        }

        return count.rem(1000000000 + 7).toInt()
    }

    private fun revertNum(it: Int): Int {
        return it.toString().reversed().toInt()
    }
}

fun main(args: Array<String>) {
    val solution = CountNicePairsInArray()
    solution.countNicePairs(intArrayOf(42, 11, 1, 97))
}