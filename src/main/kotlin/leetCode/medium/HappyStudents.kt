package leetCode.medium

class HappyStudents {
    fun countWays(nums: List<Int>): Int {
        val sorted = nums.sorted()

        var i = 0
        var count = 0

        if (sorted[0] != 0) count++

        while (i < sorted.size) {
            val cnt = i + 1
            if (sorted[i] < cnt && (cnt == sorted.size || cnt < sorted[i + 1])) {
                count++
            }
            i++
        }

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