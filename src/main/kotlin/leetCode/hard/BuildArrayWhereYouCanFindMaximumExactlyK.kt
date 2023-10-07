package leetCode.hard

class BuildArrayWhereYouCanFindMaximumExactlyK {
    fun numOfArrays(n: Int, m: Int, k: Int): Int {
        val dp = Array(n + 1) { Array(m + 1) { IntArray(k + 1) { -1 } } }
        return dfs(n, m, k, 0, 0, 0, dp)
    }

    private fun dfs(
        n: Int,
        m: Int,
        k: Int,
        i: Int,
        currentMax: Int,
        currentCost: Int,
        dp: Array<Array<IntArray>>
    ): Int {
        if (i == n) {
            if (k == currentCost) return 1
            return 0
        }

        if (dp[i][currentMax][currentCost] != -1) return dp[i][currentMax][currentCost]
        var result = 0L

        result += (currentMax.toLong() * dfs(n, m, k, i + 1, currentMax, currentCost, dp)).rem(1_000_000_007)

        if (currentCost + 1 <= k) {
            for (num in currentMax + 1..m) {
                result += dfs(n, m, k, i + 1, num, currentCost + 1, dp)
                result = result.rem(1_000_000_007)
            }
        }

        dp[i][currentMax][currentCost] = result.toInt()

        return dp[i][currentMax][currentCost]
    }
}

fun main(args: Array<String>) {
    val solution = BuildArrayWhereYouCanFindMaximumExactlyK()
    println(solution.numOfArrays(2, 3, 1))
}