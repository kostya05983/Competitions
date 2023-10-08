package leetCode.hard

class MaxDotProductTwoSubsequences {
    //nums1 = [2,1,-2,5], nums2 = [3,0,-6]
    fun maxDotProduct(nums1: IntArray, nums2: IntArray): Int {
        val nums1Max = nums1.max()
        val nums1Min = nums1.min()
        val nums2Max = nums2.max()
        val nums2Min = nums2.min()

        if (nums1Max < 0 && nums2Min > 0) {
            return nums1Max * nums2Min
        }

        if (nums1Min > 0 && nums2Max < 0) {
            return nums1Min * nums2Max
        }

        val dp = Array(nums1.size) { IntArray(nums2.size) }

        return dfs(0, 0, nums1, nums2, dp)
    }

    private fun dfs(i: Int, j: Int, nums1: IntArray, nums2: IntArray, dp: Array<IntArray>): Int {
        if (i == nums1.size || j == nums2.size) {
            return 0
        }

        if (dp[i][j] != 0) return dp[i][j]

        val product = nums1[i] * nums2[j]

        val moveNext = product + dfs(i + 1, j + 1, nums1, nums2, dp)

        val moveNum1 = dfs(i + 1, j, nums1, nums2, dp)
        val moveNum2 = dfs(i, j + 1, nums1, nums2, dp)

        dp[i][j] = maxOf(moveNext, moveNum1, moveNum2)

        return dp[i][j]
    }
}

fun main(args: Array<String>) {
    val solution = MaxDotProductTwoSubsequences()
    println(solution.maxDotProduct(intArrayOf(2, 1, -2, 5), intArrayOf(3, 0, -6)))
    println(solution.maxDotProduct(intArrayOf(-1, -1), intArrayOf(1, 1)))
    println(solution.maxDotProduct(intArrayOf(-5,-1,-2), intArrayOf(3,3,5,5)))
}