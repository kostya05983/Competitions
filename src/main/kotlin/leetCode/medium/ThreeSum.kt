package leetCode.medium

class ThreeSum {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val result = HashSet<List<Int>>()

        val numbersSet = mutableMapOf<Int, Int>()
        for (i in nums.indices) {
            numbersSet[nums[i]] = i
        }

        val visited = BooleanArray(nums.size)
        val seenTriplets = HashSet<List<Int>>()

        for (i in nums.indices) {
            if (visited[i]) continue

            val x = nums[i]
            for (j in i + 1 until nums.size) {
                if (visited[j]) continue
                val search = x + nums[j]

                val found = numbersSet[-search] ?: continue

                if (found != i && found != j) {
                    result.add(listOf(x, nums[j], -search).sorted())
                }
            }
        }

        return result.map { it.toList() }
    }
}

fun main(args: Array<String>) {
    val solution = ThreeSum()
    println(solution.threeSum(intArrayOf(-1, 0, 1, 2, -1, -4)))
    println(solution.threeSum(intArrayOf(0, 1, 1)))
    println(solution.threeSum(intArrayOf(0, 0, 0)))
    println(solution.threeSum(intArrayOf(3, 0, -2, -1, 1, 2)))
}