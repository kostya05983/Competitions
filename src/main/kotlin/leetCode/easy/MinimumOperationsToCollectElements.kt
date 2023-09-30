package leetCode.easy

class MinimumOperationsToCollectElements {
    fun minOperations(nums: List<Int>, k: Int): Int {
        val set = mutableSetOf<Int>()
        for (i in 0 until k) {
            set.add(i + 1)
        }

        var count = 0
        for (i in nums.size - 1 downTo 0) {
            val num = nums[i]
            count++
            set.remove(num)

            if (set.isEmpty()) {
                return count
            }
        }

        return count
    }
}

fun main(args: Array<String>) {

    val solution = MinimumOperationsToCollectElements()
    println(solution.minOperations(listOf(3, 1, 5, 4, 2), 2))

}