package leetCode.medium

class MinimumFallingPathSum {
    fun minFallingPathSum(matrix: Array<IntArray>): Int {
        var min = Int.MAX_VALUE
        val memo = HashMap<Pair<Int, Int>, Int>()
        for (j in matrix.indices) {
            min = minOf(minSum(matrix, 0, j, memo), min)
        }

        return min
    }

    private fun minSum(matrix: Array<IntArray>, i: Int, j: Int, memo: MutableMap<Pair<Int, Int>, Int>): Int {
        val n = matrix.size

        if (j >= n || j < 0) return Int.MAX_VALUE
        if (i == matrix.lastIndex) return matrix[i][j]

        val key = i to j
        val memorized = memo[key]
        if (memorized != null) return memorized

        val left = minSum(matrix, i + 1, j - 1, memo)
        val bottom = minSum(matrix, i + 1, j, memo)
        val right = minSum(matrix, i + 1, j + 1, memo)

        val result = minOf(left, bottom, right) + matrix[i][j]

        memo[key] = result

        return result
    }
}