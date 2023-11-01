package leetCode.easy

class GetMaximumInGeneratedArray {
    fun getMaximumGenerated(n: Int): Int {
        val dp = IntArray(101)
        dp[0] = 0
        if (n == 0) return 0

        dp[1] = 1
        var currentN = 1

        var max = 1

        while (currentN < n) {
            currentN++

            if (currentN.rem(2) == 0) {
                dp[currentN] = dp[currentN / 2]
            } else {
                dp[currentN] = dp[currentN / 2] + dp[currentN / 2 + 1]
            }
            max = maxOf(dp[currentN], max)
        }

        return max
    }
}

fun main(args: Array<String>) {
    val solution = GetMaximumInGeneratedArray()
    println(solution.getMaximumGenerated(7))
    println(solution.getMaximumGenerated(2))
    println(solution.getMaximumGenerated(3))
    println(solution.getMaximumGenerated(100))
}