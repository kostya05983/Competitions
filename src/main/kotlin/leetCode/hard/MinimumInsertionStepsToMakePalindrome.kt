package leetCode.hard

class MinimumInsertionStepsToMakePalindrome {
    fun minInsertions(s: String): Int {
        val dp = Array(s.length) { IntArray(s.length) { -1 } }
        val longest = longestPalidromicSubsequence(0, s.length - 1, s, dp)

        return s.length - longest
    }

    private fun longestPalidromicSubsequence(i: Int, j: Int, s: String, dp: Array<IntArray>): Int {
        if (i == j) {
            dp[i][j] = 1
            return dp[i][j]
        }

        if (s[i] == s[j] && i + 1 == j) {
            dp[i][j] = 2
            return dp[i][j]
        }

        if (dp[i][j] != -1) {
            return dp[i][j]
        }

        if (s[i] == s[j]) {
            dp[i][j] = longestPalidromicSubsequence(i + 1, j - 1, s, dp) + 2
            return dp[i][j]
        }

        dp[i][j] = maxOf(longestPalidromicSubsequence(i, j - 1, s, dp), longestPalidromicSubsequence(i + 1, j, s, dp))

        return dp[i][j]
    }
}

fun main(args: Array<String>) {
    val solution = MinimumInsertionStepsToMakePalindrome()
    println(solution.minInsertions("zzazz"))
    println(solution.minInsertions("mbadm"))
    println(solution.minInsertions("leetcode"))
    println(solution.minInsertions("fjbixpdtkbcevrjrvecbktdpxibjf"))
}