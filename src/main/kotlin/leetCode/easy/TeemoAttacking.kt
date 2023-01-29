package leetCode.easy

class TeemoAttacking {
    fun findPoisonedDuration(timeSeries: IntArray, duration: Int): Int {
        var result = 0
        for (i in 1 until timeSeries.size) {
            val left = timeSeries[i - 1]
            val right = timeSeries[i]
            val diff = right - left

            result += if (diff > duration) {
                duration
            } else {
                diff
            }
        }
        result += duration

        return result
    }
}

fun main(args: Array<String>) {
    val solution = TeemoAttacking()
    val test1 = solution.findPoisonedDuration(intArrayOf(1, 4), 2)
    require(test1 == 4)
    val test2 = solution.findPoisonedDuration(intArrayOf(1, 2), 2)
    require(test2 == 3)
    val test3 = solution.findPoisonedDuration(intArrayOf(1, 2, 3, 4), 2)
    require(test3 == 5)
}