package leetCode.hard

class NumberOfSubmatricesThatSumTarget {
    fun numSubmatrixSumTarget(matrix: Array<IntArray>, target: Int): Int {
        val prefixSum = Array(matrix.size + 1) { IntArray(matrix[0].size + 1) }

        for (i in 1 until prefixSum.size) {
            for (j in 1 until prefixSum[0].size) {
                val up = prefixSum[i - 1][j]
                val left = prefixSum[i][j - 1]
                val leftUp = prefixSum[i - 1][j - 1]

                prefixSum[i][j] = up + left - leftUp + matrix[i - 1][j - 1]
            }
        }


        val prefixSumToCount = hashMapOf<Int, Int>()
        var count = 0
        for (row1 in 1 until prefixSum.size) {
            for (row2 in row1 until prefixSum.size) {
                prefixSumToCount.clear()
                prefixSumToCount[0] = 1
                for (j in 1 until prefixSum[0].size) {
                    val currentSum = prefixSum[row2][j] - prefixSum[row1 - 1][j]

                    count += prefixSumToCount.getOrDefault(currentSum - target, 0)

                    prefixSumToCount[currentSum] = prefixSumToCount.getOrDefault(currentSum, 0) + 1
                }
            }
        }

        return count
    }
}

fun main(args: Array<String>) {
    val solution = NumberOfSubmatricesThatSumTarget()
    println(solution.numSubmatrixSumTarget(arrayOf(intArrayOf(0, 1, 0), intArrayOf(1, 1, 1), intArrayOf(0, 1, 0)), 0))
    println(solution.numSubmatrixSumTarget(arrayOf(intArrayOf(1, -1), intArrayOf(-1, 1)), 0))
    println(solution.numSubmatrixSumTarget(arrayOf(intArrayOf(904)), 0))
}