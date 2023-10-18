package leetCode.easy

class AverageValueOfEventNumbersDivisibleByThree {
    fun averageValue(nums: IntArray): Int {
        var sum = 0
        var count = 0

        for (num in nums) {
            if (num.rem(3) == 0 && num.rem(2) == 0) {
                sum += num
                count++
            }
        }

        return if (count == 0) 0 else sum / count
    }
}

fun main(args: Array<String>) {
    val solution = AverageValueOfEventNumbersDivisibleByThree()
    println(solution.averageValue(intArrayOf(1, 3, 6, 10, 12, 15)))
    println(solution.averageValue(intArrayOf(9, 3, 8, 4, 2, 5, 3, 8, 6, 1)))
    println(solution.averageValue(intArrayOf(94,65,82,40,79,74,92,84,37,19,16,85,20,79,25,89,55,67,84,3,79,38,16,44,2,54,58,94,69,71,14,24,13,21)))
}