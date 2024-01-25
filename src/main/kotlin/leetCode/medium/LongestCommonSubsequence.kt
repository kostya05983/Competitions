package leetCode.medium

class LongestCommonSubsequence {


    fun longestCommonSubsequence(text1: String, text2: String): Int {
        return bottomUp(text1, text2)
    }

    private fun bottomUp(text1: String, text2: String): Int {
        val dp = Array(text1.length + 1) { IntArray(text2.length + 1) { 0 } }

        for (i in text1.length - 1 downTo 0) {
            for (j in text2.length - 1 downTo 0) {
                if (text1[i] == text2[j]) {
                    dp[i][j] = 1 + dp[i + 1][j + 1]
                } else {
                    dp[i][j] = maxOf(dp[i][j + 1], dp[i + 1][j])
                }
            }
        }

        return dp[0][0]
    }

    private fun recursive(
        text1: String,
        text2: String,
        left: Int,
        right: Int,
        memo: Array<IntArray>
    ): Int {
        if (left >= text1.length) return 0
        if (right >= text2.length) return 0
        if (memo[left][right] != -1) return memo[left][right]

        val result = if (text1[left] == text2[right]) {
            1 + recursive(text1, text2, left + 1, right + 1, memo)
        } else {
            maxOf(recursive(text1, text2, left, right + 1, memo), recursive(text1, text2, left + 1, right, memo))
        }
        memo[left][right] = result

        return result
    }
}

fun main(args: Array<String>) {
    val solution = LongestCommonSubsequence()
    println(solution.longestCommonSubsequence("actgattag", "gtgtgatcg"))
    println(solution.longestCommonSubsequence("abcde", "ace"))
    println(solution.longestCommonSubsequence("abc", "abc"))
    println(solution.longestCommonSubsequence("abc", "def"))
}