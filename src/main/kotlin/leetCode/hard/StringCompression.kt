package leetCode.hard

class StringCompression {
    fun getLengthOfOptimalCompression(s: String, k: Int): Int {
        val n = s.length
        val dp = Array(110) { IntArray(110) }

        for (i in 0..n) for (j in 0..n) dp[i][j] = 9999

        dp[0][0] = 0

        for (i in 1..n) {
            for (j in 0..k) {
                var cnt = 0
                var del = 0

                for (l in i downTo 1) {
                    if (s[l - 1] == s[i - 1]) cnt++ else del++

                    if (j - del >= 0) {
                        dp[i][j] = minOf(
                            dp[i][j],
                            dp[l - 1][j - del] + 1 + if (cnt >= 100) 3 else if (cnt >= 10) 2 else if (cnt >= 2) 1 else 0
                        )
                    }
                }
                if (j > 0) dp[i][j] = minOf(dp[i][j], dp[i - 1][j - 1])
            }
        }

        return dp[n][k]
    }
}

fun main(args: Array<String>) {
    val solution = StringCompression()
    println(solution.getLengthOfOptimalCompression("aaabcccd", 2))
}