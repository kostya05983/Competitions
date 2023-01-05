package leetCode.easy

class BestTimeToBuyAndSellStock {

    fun maxProfit(prices: IntArray): Int {
        if (prices.isEmpty()) return 0
        if (prices.size == 1) return 0

        var min = prices[0]
        var maxProfit = 0

        for (i in 1 until prices.size) {
            val price = prices[i]
            min = minOf(min, price)

            val profit = prices[i] - min
            maxProfit = maxOf(maxProfit, profit)
        }

        return maxProfit
    }
}

fun main(args: Array<String>) {
    println(BestTimeToBuyAndSellStock().maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
    println(BestTimeToBuyAndSellStock().maxProfit(intArrayOf(7, 6, 4, 3, 1)))
    println(BestTimeToBuyAndSellStock().maxProfit(intArrayOf(6,7)))
    println(BestTimeToBuyAndSellStock().maxProfit(intArrayOf(2, 1, 2, 1, 0, 1, 2)))
    println(BestTimeToBuyAndSellStock().maxProfit(intArrayOf(2, 4, 1)))
}