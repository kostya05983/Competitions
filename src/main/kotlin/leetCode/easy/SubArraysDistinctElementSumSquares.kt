package leetCode.easy

class SubArraysDistinctElementSumSquares {
    fun sumCounts(nums: List<Int>): Int {
        var result = 0
        for (window in 1..nums.size) {
            var startPoint = 0
            while (startPoint + window <= nums.size) {
                val hashSet = HashSet<Int>()
                for (j in startPoint until startPoint + window) {
                    hashSet.add(nums[j])
                }
                startPoint += 1
                result += hashSet.size * hashSet.size
            }
        }

        return result
    }
}

fun main(args: Array<String>) {
    val solution = SubArraysDistinctElementSumSquares()
    println(solution.sumCounts(listOf(1, 2, 1)))
    println(solution.sumCounts(listOf(1, 1)))
}