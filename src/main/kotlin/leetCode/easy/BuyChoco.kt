package leetCode.easy

class BuyChoco {
    fun buyChoco(prices: IntArray, money: Int): Int {
        prices.sort()

        val firstChoco = prices[0]
        val secondChoco = prices[1]

        if (firstChoco + secondChoco > money) return money

        return money - firstChoco - secondChoco
    }
}