package leetCode.medium

class MaximumNumberOfCoins {
    fun maxCoins(piles: IntArray): Int {
        piles.sort()

        var right = piles.size - 1
        var left = 0
        var result = 0
        while (left < right) {
            result += piles[right - 1]
            right -= 2
            left++
        }

        return result
    }
}

fun main(args: Array<String>) {
    val solution = MaximumNumberOfCoins()
    println(solution.maxCoins(intArrayOf(2, 4, 1, 2, 7, 8)))
    println(solution.maxCoins(intArrayOf(2, 4, 5)))
    println(solution.maxCoins(intArrayOf(9, 8, 7, 6, 5, 1, 2, 3, 4)))
}