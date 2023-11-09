package leetCode.medium

import java.util.TreeSet

class CountNumberOfTeams {
    fun numTeams(rating: IntArray): Int {
        var count = 0

        val dp = Array(2) { IntArray(rating.size) }
        for (i in 0 until rating.size) {
            for (j in i downTo 0) {
                if (rating[i] > rating[j]) {
                    dp[0][i]++
                    count += dp[0][j]
                }
                if (rating[i] < rating[j]) {
                    dp[1][i]++
                    count += dp[1][j]
                }
            }
        }

        return count
    }
}

fun main(args: Array<String>) {
    val solution = CountNumberOfTeams()
    println(solution.numTeams(intArrayOf(2, 5, 3, 4, 1)))
}