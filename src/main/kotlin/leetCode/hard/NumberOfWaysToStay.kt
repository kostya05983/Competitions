package leetCode.hard

import java.util.Arrays

class NumberOfWaysToStay {
    fun numWays(steps: Int, arrLen: Int): Int {
        val mod = 1000000000 + 7
        val len = minOf(arrLen, steps)
        val dp = Array(len) { IntArray(steps + 1) }
        dp[0][0] = 1

        for (i in 1..steps) {
            for (j in len - 1 downTo 0) {
                var result = dp[j][i - 1]

                if (j > 0) {
                    result = (result + dp[j - 1][i - 1]).rem(mod)
                }
                if (j < len - 1) {
                    result = (result + dp[j + 1][i - 1]).rem(mod)
                }

                dp[j][i] = result
            }
        }

        return dp[0][steps]
    }
}