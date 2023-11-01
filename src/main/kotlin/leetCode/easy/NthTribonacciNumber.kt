package leetCode.easy

class NthTribonacciNumber {
    fun tribonacci(n: Int): Int {
        val dp = IntArray(38) { -1 }
        dp[0] = 0
        dp[1] = 1
        dp[2] = 1

        if (n <= 2) return dp[n]

        var currentN = 2
        while (currentN < n) {
            currentN++
            dp[currentN] = dp[currentN - 1] + dp[currentN - 2] + dp[currentN - 3]
        }

        return dp[n]
    }
}

fun main(args: Array<String>) {
    val solution = NthTribonacciNumber()
    println(solution.tribonacci(30))
}