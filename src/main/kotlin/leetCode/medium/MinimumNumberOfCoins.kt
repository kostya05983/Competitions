package leetCode.medium

class MinimumNumberOfCoins {
    fun minimumCoins(prices: IntArray): Int {
        val dp = IntArray(1001)

        return buyNext(0, prices, dp)
    }

    private fun buyNext(i: Int, prices: IntArray, dp: IntArray): Int {
        if (i >= prices.size) return 0
        if (dp[i] != 0) return dp[i]
        var res = Int.MAX_VALUE
        for (j in i + 1..2 * i + 2) {
            res = minOf(res, buyNext(j, prices, dp))
        }

        dp[i] = res + prices[i]

        return dp[i]
    }
}

fun main(args: Array<String>) {
    val solution = MinimumNumberOfCoins()
    println(solution.minimumCoins(intArrayOf(3, 1, 2)))
    println(solution.minimumCoins(intArrayOf(1, 10, 1, 1)))
    println(solution.minimumCoins(intArrayOf(18, 10, 1, 11, 6, 30, 19, 24, 1, 18, 37, 29, 28, 27, 38)))
    println(solution.minimumCoins(intArrayOf(14, 37, 37, 38, 24, 15, 12)))
    println(
        solution.minimumCoins(
            intArrayOf(
                176,
                391,
                307,
                836,
                76,
                650,
                625,
                648,
                466,
                990,
                643,
                399,
                422,
                604,
                328,
                343,
                835,
                153,
                92,
                171,
                802,
                731,
                483,
                469,
                27,
                307,
                194,
                427,
                824,
                503,
                661,
                5,
                540,
                761,
                127,
                579,
                324,
                997,
                891,
                809,
                968,
                855,
                397,
                730,
                583,
                549,
                493,
                471,
                809,
                860,
                771,
                502,
                177,
                25,
                107,
                26,
                321,
                796,
                726,
                519,
                800,
                764,
                804,
                50,
                471,
                812,
                747,
                862,
                220
            )
        )
    )
}