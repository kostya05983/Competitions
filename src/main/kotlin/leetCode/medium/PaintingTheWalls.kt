package leetCode.medium

class PaintingTheWalls {
    fun paintWalls(cost: IntArray, time: IntArray): Int {
        val dp = IntArray(cost.size + 1) { 1000000000 }
        dp[0] = 0

        for (i in cost.indices)
            for (j in cost.size downTo 1) {
                dp[j] = minOf(dp[j], dp[maxOf(j - time[i] - 1, 0)] + cost[i])
            }

        return dp[cost.size]
    }
}

fun main(args: Array<String>) {
    val solution = PaintingTheWalls()
    println(solution.paintWalls(intArrayOf(1, 2, 3, 2), intArrayOf(1, 2, 3, 2)))
    println(solution.paintWalls(intArrayOf(2, 3, 4, 2), intArrayOf(1, 1, 1, 1)))
}