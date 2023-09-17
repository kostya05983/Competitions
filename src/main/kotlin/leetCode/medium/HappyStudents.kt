package leetCode.medium

class HappyStudents {
    fun countWays(nums: List<Int>): Int {
        val sorted = nums.sorted()

        val n = sorted.size

        var sum = 0
        var i = 0
        var count = 0
        var wasZero = false

        val set = mutableSetOf<Int>()
        for (num in nums) {
            set.add(num)
        }

        while (i < sorted.size - 1) {
            if (sorted[i] < (i + 1) && sorted[i] < sorted[i + 1]) {
                if (!set.contains(i + 1) && sorted[i + 1] > i + 1) {
                    count++
                }
            }
            if (sorted[i] == 0) wasZero = true

            sum += sorted[i]
            i++
        }
        if (sorted.last() < n) {
            count++
        }
        if (nums.last() == 0) wasZero = true
        if (!wasZero) count++


        return count
    }
}

fun main(args: Array<String>) {
    val solution = HappyStudents()
    val example1 = solution.countWays(listOf(1, 1))
    println(example1)
////
    val example2 = solution.countWays(listOf(6, 0, 3, 3, 6, 7, 2, 7))
    println(example2)
////
    val example3 = solution.countWays(listOf(0, 1, 1, 1))
    println(example3)

    val example4 = solution.countWays(listOf(5, 0, 3, 4, 2, 1, 2, 4))
    println(example4)

    val example5 = solution.countWays(listOf(0))
    println(example5)
}