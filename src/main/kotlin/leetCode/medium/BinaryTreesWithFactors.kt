package leetCode.medium

class BinaryTreesWithFactors {
    fun numFactoredBinaryTrees(arr: IntArray): Int {
        arr.sort()
        val dp = HashMap<Int, Long>()

        val mod = 1000000000 + 7
        for (i in arr.indices) {
            val numI = arr[i]
            dp[numI] = 1L

            for (j in 0 until i) {
                val numJ = arr[j]

                if (numI.rem(numJ) != 0) continue

                val key = (numI / numJ)
                if (key in dp) {
                    dp[numI] = dp[numI]!! + dp[numJ]!! * dp[key]!!
                }

            }
        }

        return dp.values.sum().rem(mod).toInt()
    }
}

fun main(args: Array<String>) {
    val solution = BinaryTreesWithFactors()
    println(solution.numFactoredBinaryTrees(intArrayOf(2, 4)))
    println(solution.numFactoredBinaryTrees(intArrayOf(2, 4, 5, 10)))
}