package leetCode.medium

class OutOfBoundaryPaths {
    private val mod = 1_000_000_007

    fun findPaths(m: Int, n: Int, maxMove: Int, startRow: Int, startColumn: Int): Int {
        var dp = Array(m) { IntArray(n) }
        dp[startRow][startColumn] = 1

        var count = 0
        for (moves in 1..maxMove) {
            val temp = Array(m) { IntArray(n) }
            for (i in 0 until m) {
                for (j in 0 until n) {
                    if (i == m - 1) count = (count + dp[i][j]).rem(mod)
                    if (j == n - 1) count = (count + dp[i][j]).rem(mod)
                    if (i == 0) count = (count + dp[i][j]).rem(mod)
                    if (j == 0) count = (count + dp[i][j]).rem(mod)

                    val left = if (i > 0) dp[i - 1][j] else 0
                    val right = if (i < m - 1) dp[i + 1][j] else 0
                    val bottom = if (j > 0) dp[i][j - 1] else 0
                    val up = if (j < n - 1) dp[i][j + 1] else 0

                    temp[i][j] = ((left + right).rem(mod) + (bottom + up).rem(mod)).rem(mod)
                }
            }
            dp = temp
        }

        return count
    }

    private fun findPaths(
        m: Int,
        n: Int,
        maxMove: Int,
        startRow: Int,
        startColumn: Int,
        memo: Array<Array<IntArray>>
    ): Int {
        if (startRow == m || startColumn == n || startRow < 0 || startColumn < 0) return 1
        if (maxMove == 0) return 0

        if (memo[startRow][startColumn][maxMove] > 0) return memo[startRow][startColumn][maxMove]

        val result = findPaths(m, n, maxMove - 1, startRow + 1, startColumn) +
                +findPaths(m, n, maxMove - 1, startRow - 1, startColumn) +
                findPaths(m, n, maxMove - 1, startRow, startColumn + 1) +
                findPaths(m, n, maxMove - 1, startRow, startColumn - 1)
        memo[startRow][startColumn][maxMove] = result.rem(mod)
        return result
    }

//    private fun recursive(dp: Array<LongArray>, moves: Int, x: Int, y: Int): Long {
//
//        if (moves == 0) {
//            return 0
//        }
//        if (x < 0 || x >= dp.size) {
//            return dp[x + 1][y]
//        }
//        if (x >= dp.size) {
//            return dp[x - 1][y]
//        }
//        if (y < 0) {
//            return dp[x][y + 1]
//        }
//        if (y >= dp.size) {
//            return dp[x][y - 1]
//        }
//        if (dp[x][y] != -1L) return 0
//
//        dp[x][y] = 1 + dp[x].getOrElse(y + 1, { 0 }) + dp[x].getOrElse(y - 1, { 0 })
//        +(dp.getOrNull(x + 1)?.let { it[y] } ?: 0) + (dp.getOrNull(x - 1)?.let { it[y] } ?: 0)
//
//        val right = recursive(dp, depth + 1, moves, x + 1, y)
//        val left = recursive(dp, depth + 1, moves, x - 1, y)
//        val up = recursive(dp, depth + 1, moves, x, y + 1)
//        val bottom = recursive(dp, depth + 1, moves, x, y - 1)
//
//        return right + left + up + bottom
//    }
}

fun main(args: Array<String>) {
    val solution = OutOfBoundaryPaths()
    println(solution.findPaths(2, 2, 2, 0, 0))
    println(solution.findPaths(1, 3, 3, 0, 1))
}