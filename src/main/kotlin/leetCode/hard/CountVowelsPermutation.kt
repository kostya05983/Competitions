package leetCode.hard

class CountVowelsPermutation {
    fun countVowelPermutation(n: Int): Int {
        val dp = Array(n) { LongArray(5) }
        for (i in 0 until 5) {
            dp[0][i] = 1
        }

        val mod = 1000000000 + 7

        for (i in 1 until n) {
            for (j in 0 until 5) {
                when (j) {
                    0 -> {
                        //e+i+u
                        dp[i][j] = dp[i - 1][j + 1] + dp[i - 1][j + 2] + dp[i - 1][j + 4]
                    }

                    1 -> {
                        //a+i
                        dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1]
                    }

                    2 -> {
                        //e+o
                        dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1]
                    }

                    3 -> {
                        // i
                        dp[i][j] = dp[i - 1][j - 1]
                    }

                    4 -> {
                        //o+i
                        dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j - 2]
                    }
                }
                dp[i][j] = dp[i][j].rem(mod)
            }
        }

        var result = 0L
        for (i in 0 until 5) {
            result += dp[n - 1][i]
            result = result.rem(mod)
        }

        return result.rem(mod).toInt()
    }
}

fun main(args: Array<String>) {
    val solution = CountVowelsPermutation()
    println(solution.countVowelPermutation(1))
    println(solution.countVowelPermutation(2))
    println(solution.countVowelPermutation(5))
}